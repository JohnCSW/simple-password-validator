# Simple Password Validator
A simple password validator that implements basic password validation rules.
## Configuration:
1. `git clone https://github.com/JohnCSW/simple-password-validator.git`
2.  Make sure you have [Maven](https://maven.apache.org/) installed,
    and use maven as your build tools.
3. `mvn install` under this project directory.
4. Add the snippet below on `pom.xml` under your project directory

    ```
    <dependencies>
    ...
        <dependency>
            <groupId>xyz.john-csw</groupId>
            <artifactId>simple-password-validator</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
    ...
    </dependencies>
    ```

5. If facing errors like 
`[ERROR] Source option 1.5 is no longer supported. Use 1.6 or later.`
then paste the following snippet on `pom.xml`, replace the version of
`<source>` and `<target>` for your own settings.

    ```
    <build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <configuration>
                <source>7</source>
                <target>7</target>
            </configuration>
        </plugin>
    </plugins>
    </build>
    ```
6. Make sure you're using [Spring](https://spring.io/projects/spring-framework) based dependency injection engine.
7. Add `ValidatorBeanConfig.java`, `ValidationRuleBeanConfig.java` along with your bean config in
`ApplicationContext.java` class.
8. You can use `App.java` to play around to see what it looks like
   upon running.
## Usage:

```java
public class Client {
    @Autowired
    @Qualifier("defaultValidator")
    private Validator defaultValidator;
    
    public void someOperation(String password) {
        if (defaultValidator.check(password)) {
            // pass
        } else {
            // fail
            defaultValidator.getErrorMessages();
            // do something with error messages
        }
    }
}
```
## License:
The MIT License (MIT)
