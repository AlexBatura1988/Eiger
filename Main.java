import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        HashMap<String, ArrayList<Float>> map = new HashMap<String, ArrayList<Float>>();

        for (int i = 0; i < productSold.size(); i++) {
            String pSold = productSold.get(i);
            if (map.containsKey(pSold)) {
                ArrayList<Float> list = map.get(pSold);
                list.add(soldPrice.get(i));
                map.put(pSold, list);
            } else {
                ArrayList<Float> list = new ArrayList<Float>();
                list.add(soldPrice.get(i));
                map.put(pSold, list);
            }
        }
        HashMap<String, Float> map2 = new HashMap<String, Float>();
        for (int i = 0; i < products.size(); i++) {
            map2.put(products.get(i), productPrices.get(i));
        }

        int error = 0;
        for (Map.Entry<String, Float> map3 : map2.entrySet()) {
            String pName = map3.getKey();
            Float pCost = map3.getValue();
            if (map.containsKey(pName)) {
                ArrayList<Float> price = map.get(pName);
                for (int i = 0; i < price.size(); i++) {
                    Float sCost = price.get(i);
                    if (pCost - sCost != 0.0)
                        error++;
                }
            }
        }
        return error;
    }

    public static int summer(int n) {
        if (n == 0)
            return 0;
        return (n % 10 + summer(n / 10));
    }

    //Exercise SQL
    /*
    SELECT * FROM
(
SELECT
	D.Name AS DepartmentName, COUNT(E.Id) OVER(PARTITION BY E.Department_ID) AS EmployeesNumber
FROM
	Department AS D
LEFT JOIN
	Employee AS E
ON
	D.Id = E.Department_ID
) AS Dept
GROUP BY
    DepartmentName, EmployeesNumber
ORDER BY
    DepartmentName ASC

     */


    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        List<Float> productPrices = new ArrayList<>();
        List<String> productSold = new ArrayList<>();
        List<Float> soldPrice = new ArrayList<>();
        products.add("eggs");
        products.add("milk");
        products.add("cheese");

        productPrices.add((float) 2.89);
        productPrices.add((float) 3.29);
        productPrices.add((float) 5.79);

        productSold.add("eggs");
        productSold.add("eggs");
        productSold.add("cheese");
        productSold.add("milk");

        soldPrice.add((float) 2.89);
        soldPrice.add((float) 2.99);
        soldPrice.add((float) 5.97);
        soldPrice.add((float) 3.29);

        System.out.println(priceCheck(products, productPrices, productSold, soldPrice));

        System.out.println(summer(2347623));


    }
}
