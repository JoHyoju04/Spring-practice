package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/*
-자바 코드로 직접 스프링 빈 등록하기
 회원 서비스와 회원 리포지토리의 @Service,@Repository,@Autowired 애노테이션을 제거하고 진행한다.
 */

@Configuration
public class SpringConfig {
    //private final MemberRepository memberRepository; //스프링 데이터 JPA

    private final DataSource dataSource;

    private EntityManager em;

    public SpringConfig(DataSource dataSource,EntityManager em) {
        this.dataSource = dataSource;
        this.em=em;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
    // return new MemoryMemberRepository();
    //return new JdbcMemberRepository(dataSource);
    return new JpaMemberRepository((em));
    }


}
