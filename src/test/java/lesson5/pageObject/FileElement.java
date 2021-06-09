package lesson5.pageObject;

import static com.codeborne.selenide.Selenide.$;

public class FileElement {
    public void uploadFile(String nameFile) {
        $("#uploadPicture").uploadFromClasspath("img/"+nameFile);
    }
}
