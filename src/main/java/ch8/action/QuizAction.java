package ch8.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Validations
public class QuizAction extends ActionSupport {

    private String name;
    private int age;
    private String answer;

    public QuizAction() {
    }

    public String getName() {
        return name;
    }

    @RequiredFieldValidator(
            type = ValidatorType.FIELD,
            message = "값을 입력하세요"
    )
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
