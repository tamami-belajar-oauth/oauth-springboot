package lab.aikibo.oauthauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class OauthAuthServerApplication {

    public static void main(String[] args) {
		SpringApplication.run(OauthAuthServerApplication.class, args);
	}


	@GetMapping("/private")
	public void privatePage() {}

    /*
	@Bean
	public void authenticationManager(AuthenticationManagerBuilder builder, UsersRepo repo) throws Exception {
	    if(repo.count() == 0) {
            repo.save(new Users("user","user", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
        }

	    builder.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
                System.out.println("repo -> " + repo.findByUsername(s).getUsername());
                return new CustomUserDetails(repo.findByUsername(s));
            }
        });
    }
    */
}
