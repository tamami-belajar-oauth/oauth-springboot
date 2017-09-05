package lab.aikibo.oauthauthserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Created by tamami on 05/09/17.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests().antMatchers("/login").permitAll().and()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/private/**").authenticated();
    }
}
