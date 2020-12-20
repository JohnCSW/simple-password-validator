import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import xyz.johncsw.passwordValidator.beanConfig.ValidationRuleBeanConfig;
import xyz.johncsw.passwordValidator.beanConfig.ValidatorBeanConfig;
import xyz.johncsw.passwordValidator.validator.DefaultValidator;
import xyz.johncsw.passwordValidator.validator.Validator;

import java.util.Scanner;

public class App {
    public static void main(final String[] args) {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(
                    ValidationRuleBeanConfig.class, ValidatorBeanConfig.class
                );

        final Scanner scanner = new Scanner(System.in);
        // Initialization can be done via Factory if there're more validators.
        final Validator defaultValidator = applicationContext.getBean(DefaultValidator.class);
        String password = "";

        do {
            if (!defaultValidator.getErrorMessages().isEmpty()) {
                for (final String errorMessage: defaultValidator.getErrorMessages()) {
                    System.err.println(errorMessage);
                }
            }
            System.out.println("Please enter your password:");
            password = scanner.nextLine();
        } while(!defaultValidator.check(password));

        System.out.println("Hi :)");
    }
}
