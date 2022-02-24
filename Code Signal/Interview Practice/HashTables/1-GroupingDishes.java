/*
 * 1 - GroupingDishes
 * You are given a list dishes, where each element consists of a list of strings
 * beginning with the name of the dish, followed by all the ingredients used in
 * preparing it. You want to group the dishes by ingredients, so that for each
 * ingredient you'll be able to find all the dishes that contain it (if there
 * are at least 2 such dishes).
 * Return an array where each element is a list beginning with the ingredient
 * name, followed by the names of all the dishes that contain this ingredient.
 * dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
 * ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
 * ["Quesadilla", "Chicken", "Cheese", "Sauce"],
 * ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
 * solution(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
 * ["Salad", "Salad", "Sandwich"],
 * ["Sauce", "Pizza", "Quesadilla", "Salad"],
 * ["Tomato", "Pizza", "Salad", "Sandwich"] */
String[][] solution(String[][] dishes) {
    HashMap<String,List<String>> map = new HashMap<>();
    for (int i = 0; i<dishes.length; i++) {
        String currDish = "";
        for (int j=0; j<dishes[i].length; j++) {
            if (j == 0) {
                currDish = dishes[i][j];
            } else {
                String ingredient = dishes[i][j];
                if (map.containsKey(ingredient)) {
                    List<String> dishList = map.get(ingredient);
                    dishList.add(currDish);
                    map.put(ingredient, dishList);
                } else {
                    List<String> dishList = new ArrayList<>();
                    dishList.add(currDish);
                    map.put(ingredient, dishList);
                } 
            }
        }
    }
    List<List<String>> helper = new ArrayList<List<String>>();
    for (String ing : map.keySet()) {
        var curr = map.get(ing);
        if (curr.size() >= 2) {
            curr.sort(Comparator.naturalOrder());
            curr.add(0, ing);
            helper.add(curr);
        }
        
    }
    helper.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
    String[][] arr = helper.stream()
                .map(l -> l.stream().toArray(String[]::new))
                .toArray(String[][]::new);
    return arr;
}
