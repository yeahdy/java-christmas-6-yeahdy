package domain.badge;

public enum Badge {
    STAR("별",5_000),
    TREE("트리",10_000),
    SANTA("산타",20_000);

    private String name;
    private int condition;

    Badge(String name, int condition){
        this.name = name;
        this.condition = condition;
    }

    public static String getBadgeName(int totalBenefitsPrice){
        String badgeName = "없음";
        for(Badge badge : values()){
            if(badge.condition < totalBenefitsPrice){
                badgeName = badge.name;
            }
        }
        return badgeName;
    }

}
