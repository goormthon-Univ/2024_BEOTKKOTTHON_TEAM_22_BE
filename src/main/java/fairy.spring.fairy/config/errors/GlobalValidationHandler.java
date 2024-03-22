package fairy.spring.fairy.config.errors;


import org.springframework.stereotype.Component;

//@Aspect
@Component
public class GlobalValidationHandler {
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {}

//    @Before("postMapping()")
//    public void validationAdvice(JoinPoint joinPoint) {
//        Map<String, String> errorList = new HashMap<>();
//
//        Object[] args = joinPoint.getArgs(); // join point parameter
//
//        for (Object arg : args) {
//            if (arg instanceof Errors) {
//                Errors errors = (Errors) arg;
//
//                if (errors.hasErrors()) {
//                    List<FieldError> fieldErrors = errors.getFieldErrors();
//                    for (FieldError fieldError : fieldErrors) {
//                        errorList.put(fieldError.getField(), fieldError.getDefaultMessage());
//                    }
//                }
//            }
//        }
//
//        if (!errorList.isEmpty()) {
//            throw new Exception400(errorList, null);
//        }
//    }
}
