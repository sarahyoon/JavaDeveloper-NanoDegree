package edu.udacity.java.nano.chat;



        import edu.udacity.java.nano.WebSocketChatApplication;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.openqa.selenium.*;
        import org.openqa.selenium.htmlunit.HtmlUnitDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit.jupiter.SpringExtension;
        import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {WebSocketChatApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class WebSocketChatServerTest{

    private WebDriver webDriver;

    private WebDriver webDriver2;

    private String test_url = "http://localhost:8080";

    @Test
    public void loginAndJoinTest()
    {
        webDriver = new HtmlUnitDriver(true);
        webDriver.get(test_url);
        String inputName="aaa";

        WebElement username = webDriver.findElement(By.name("username"));
        username.sendKeys(inputName);

        //user login
        WebElement login = webDriver.findElement(By.className("submit"));
        login.click();

        //after login -> user join test
        assertThat(webDriver.findElement(By.id ("username")).getAttribute("innerHTML")).isEqualTo(inputName);

    }


    @Test
    public void chatAndLeave()
    {
        webDriver = new HtmlUnitDriver(true);
        webDriver2 = new HtmlUnitDriver(true);

        String username="aaa";
        webDriver.get(test_url+"/index?username="+username);

        String username2="bbb";
        webDriver2.get(test_url+"/index?username="+username2);

        //user chat
        WebElement sendText = webDriver.findElement(By.id("msg"));
        sendText.sendKeys("send text test");

        WebElement sendButton = webDriver.findElement(By.className("send"));
        sendButton.click();


        WebDriverWait wait = new WebDriverWait(webDriver2, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message-content")));
        System.out.println(element.getAttribute("textContent").length());
        assertThat(element.getAttribute("textContent").substring(4,18)).isEqualTo("send text test");

        //user leave
        WebElement leaveChat = webDriver.findElement(By.className("exit"));
        leaveChat.click();

        assertThat(webDriver.findElement(By.className("submit")).getText().equals("login"));

    }

}