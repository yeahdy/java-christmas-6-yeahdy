package view;

//NOTE: View를 생성하는 팩토리를 만들어서 생성의 책임을 준다
public class ViewFactory {
    //NOTE: VIEW 객체를 다른곳에서 함부로 생성하지 못하도록 VIEW 생성자는 protected 접근제어자로 설정해 놓고 캡슐화한다.
    // 클라이언트가 필요할 때 호출하여 객체를 생성하도록 하고, 메소드 호출 시 하나의 인스턴스를 공유할 수 있도록 재사용성을 높임
    private InputView inputView;
    private OutputView outputView;

    public InputView getInputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView getOutputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

}
