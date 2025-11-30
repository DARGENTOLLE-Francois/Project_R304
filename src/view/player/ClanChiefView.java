package view.player;

public class ClanChiefView {

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showPlaceInfo(String info) {
        System.out.println("=== PLACE INFORMATION ===");
        System.out.println(info);
    }
    
    
    public void showType() {
		System.out.println("- 1 : druide" + "\n"
				+ "- 2 : forgerons"+ "\n" + "- 3 : aubergistes"+ "\n" + "- 4 : marchands"
				+ "\n" + "- 5 : légionnaires"+ "\n" + "- 6 : préfets"+ "\n" + "- 7: généraux"
				+ "\n" + "- 8 : lycantrophe");
    }
}
