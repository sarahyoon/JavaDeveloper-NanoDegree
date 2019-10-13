yoonui-MacBook-Pro:e-commerce App yoon$ mvn spring-boot:run
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------------< com.example:auth-course >-----------------------
[INFO] Building auth-course 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.1.5.RELEASE:run (default-cli) > test-compile @ auth-course >>>
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ auth-course ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 1 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ auth-course ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ auth-course ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /Users/yoon/Desktop/JavaDeveloper-NanoDegree/e-commerce App/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ auth-course ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 3 source files to /Users/yoon/Desktop/JavaDeveloper-NanoDegree/e-commerce App/target/test-classes
[INFO] /Users/yoon/Desktop/JavaDeveloper-NanoDegree/e-commerce App/src/test/java/com/example/demo/TestUnits.java: /Users/yoon/Desktop/JavaDeveloper-NanoDegree/e-commerce App/src/test/java/com/example/demo/TestUnits.java uses or overrides a deprecated API.
[INFO] /Users/yoon/Desktop/JavaDeveloper-NanoDegree/e-commerce App/src/test/java/com/example/demo/TestUnits.java: Recompile with -Xlint:deprecation for details.
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.1.5.RELEASE:run (default-cli) < test-compile @ auth-course <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.1.5.RELEASE:run (default-cli) @ auth-course ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.5.RELEASE)

2019-10-14 00:59:11.436  INFO 21624 --- [           main] com.example.demo.SareetaApplication      : Starting SareetaApplication on yoonui-MacBook-Pro.local with PID 21624 (started by yoon in /Users/yoon/Desktop/JavaDeveloper-NanoDegree/e-commerce App)
2019-10-14 00:59:11.439  INFO 21624 --- [           main] com.example.demo.SareetaApplication      : No active profile set, falling back to default profiles: default
2019-10-14 00:59:12.141  INFO 21624 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2019-10-14 00:59:12.217  INFO 21624 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 66ms. Found 4 repository interfaces.
2019-10-14 00:59:12.946  INFO 21624 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$531367fe] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-10-14 00:59:13.001  INFO 21624 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration' of type [org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration$$EnhancerBySpringCGLIB$$ebc13038] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-10-14 00:59:13.007  INFO 21624 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'objectPostProcessor' of type [org.springframework.security.config.annotation.configuration.AutowireBeanFactoryObjectPostProcessor] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-10-14 00:59:13.009  INFO 21624 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler@7a0ce943' of type [org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-10-14 00:59:13.013  INFO 21624 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration' of type [org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration$$EnhancerBySpringCGLIB$$1095d2ea] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-10-14 00:59:13.017  INFO 21624 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'methodSecurityMetadataSource' of type [org.springframework.security.access.method.DelegatingMethodSecurityMetadataSource] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2019-10-14 00:59:13.377  INFO 21624 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2019-10-14 00:59:13.418  INFO 21624 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-10-14 00:59:13.419  INFO 21624 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.19]
2019-10-14 00:59:13.548  INFO 21624 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-10-14 00:59:13.548  INFO 21624 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2056 ms
2019-10-14 00:59:13.784  INFO 21624 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2019-10-14 00:59:14.007  INFO 21624 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2019-10-14 00:59:14.077  INFO 21624 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
        name: default
        ...]
2019-10-14 00:59:14.169  INFO 21624 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.3.10.Final}
2019-10-14 00:59:14.170  INFO 21624 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2019-10-14 00:59:14.352  INFO 21624 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final}
2019-10-14 00:59:14.507  INFO 21624 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2019-10-14 00:59:15.502  INFO 21624 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2019-10-14 00:59:16.373  WARN 21624 --- [           main] aWebConfiguration$JpaWebMvcConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2019-10-14 00:59:16.544  INFO 21624 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Creating filter chain: any request, [org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@4ee9db8b, org.springframework.security.web.context.SecurityContextPersistenceFilter@3eb2c8af, org.springframework.security.web.header.HeaderWriterFilter@320d6d29, org.springframework.web.filter.CorsFilter@e592237, org.springframework.security.web.authentication.logout.LogoutFilter@78078f77, com.example.demo.security.JwtAuthenticationFilter@6d60c875, com.example.demo.security.JwtAuthorizationFilter@2bdce9d1, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@7ff85e75, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@732cdd86, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@2be95aa2, org.springframework.security.web.session.SessionManagementFilter@64ae0891, org.springframework.security.web.access.ExceptionTranslationFilter@46f0a868, org.springframework.security.web.access.intercept.FilterSecurityInterceptor@b4f416a]
2019-10-14 00:59:16.794  INFO 21624 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-10-14 00:59:17.074  INFO 21624 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-10-14 00:59:17.079  INFO 21624 --- [           main] com.example.demo.SareetaApplication      : Started SareetaApplication in 6.292 seconds (JVM running for 11.442)
2019-10-14 01:00:18.216  INFO 21624 --- [nio-8080-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2019-10-14 01:00:18.217  INFO 21624 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2019-10-14 01:00:18.227  INFO 21624 --- [nio-8080-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 10 ms
2019-10-14 01:00:18.369  INFO 21624 --- [nio-8080-exec-2] c.e.demo.controllers.UserController      : User name set with value: yoon
2019-10-14 01:00:18.588  INFO 21624 --- [nio-8080-exec-2] c.e.demo.controllers.UserController      : Create yoon Success!
2019-10-14 01:00:39.357  INFO 21624 --- [nio-8080-exec-3] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
2019-10-14 01:01:07.054  INFO 21624 --- [nio-8080-exec-5] c.e.demo.controllers.OrderController     : Order success with id: '1'
