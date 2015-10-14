package capitulo3.ex10;

public class TesteEditor {

	public static void main(String[] args) {
		Editor editor = new Editor();
		
		editor.I();
		editor.I();
		editor.I(0);
		
		System.out.println(editor.L());
		
		editor.E(0, 1);
		
		System.out.println(editor.L());
		
		editor.I();
		editor.I();
		
		System.out.println(editor.L());
		
		editor.D(0, 2, 0);
		
		System.out.println(editor.L());

	}

}
