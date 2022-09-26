package edu.java.inner02;

public class Button {
    // static inner interface
    public static interface OnClickListener {
        void onClick(); // 추상메서드(public abstract 생략) (interface 에서는 추상메서드만 사용 가능, 추상메서드는 public으로 공개가 되어야됨)
    }

    // field
    private String btnName;
    private OnClickListener listener;

    // constructor
    public Button(String btnName) {
        this.btnName = btnName;
    }
    
    //method
    public void setOnClickListener(OnClickListener l) {
        this.listener = l; 
    }
    
    public void click() {
        System.out.print(btnName + "버튼:");
        listener.onClick();
    }

}
