package lab.aikibo.oauthauthserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.sql.DataSource;

/**
 * Created by tamami on 05/09/17.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/bower_components/**", "/style/**", "/login**", "/public.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"));
                /*
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/private")
                .and()
                .logout();
                */

                /*
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll();
                */

                /*
            .authorizeRequests().antMatchers("/login").permitAll().and()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/private/**").hasRole("UPDATE");//.authenticated();
                */
    }

    /*
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active as enabled from users where username=?")
                .authoritiesByUsernameQuery("select users.username, perm.user_role from users inner join permission perm " +
                        "on users.id = perm.id_user where users.username=?");
    }
    */

}
