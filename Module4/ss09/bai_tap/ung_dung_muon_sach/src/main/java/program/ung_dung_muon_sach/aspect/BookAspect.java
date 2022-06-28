package program.ung_dung_muon_sach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import program.ung_dung_muon_sach.repository.ICountViewRepository;

import java.util.Arrays;


@Component
@Aspect
public class BookAspect {
    @Autowired
    private ICountViewRepository iCountViewRepository;

    @Before("execution(public * program.ung_dung_muon_sach.controller.BookController.*(..))")
    public void logBookBeforeHistory(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.err.println("Đã vô method : " + methodName + " .Thuộc class " + className);
    }

    @Before("execution(public * program.ung_dung_muon_sach.controller.BookController.displayListBook(..))")
    public void CountViewByDisplayListBook(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        iCountViewRepository.add1view();
        System.err.println("Đã có ngưởi ghé thăm library thông qua method "  + methodName + " .Thuộc class " + className);
    }
    @Before("execution(public * program.ung_dung_muon_sach.controller.BookController.displayListBookDetail(..))")
    public void CountViewByDisplayRent(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        iCountViewRepository.add1view();
        System.err.println("Đã có ngưởi ghé thăm rent thông qua method "  + methodName + " .Thuộc class " + className);
    }

    @Before("execution(public * program.ung_dung_muon_sach.controller.BookController.displayReturnPage(..))")
    public void displayReturnPage(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        iCountViewRepository.add1view();
        System.err.println("Đã có ngưởi ghé thăm return thông qua method "  + methodName + " .Thuộc class " + className);
    }



    @AfterReturning(pointcut = "execution(public * program.ung_dung_muon_sach.controller.BookController.*(..))")
    public void logBookAfterReturningHistory(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();

        System.err.println("Method vừa mới thực hiện xong là : " + methodName);
    }

    @AfterThrowing(pointcut = "execution(public * program.ung_dung_muon_sach.controller.BookController.*(..))", throwing = "e")
    public void logBookAfterHaveExceptionHistory(JoinPoint joinPoint, Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
//        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("Lỗi ở class: "+ className +  " tại method: " + methodName + " .Nguyên nhân:"+ e.getMessage());
    }
}
