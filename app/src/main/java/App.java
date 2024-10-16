import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            DataHandler dataHandler;

            // ユーザーの選択に基づいて適切なデータハンドラーを生成
            if ("1".equals(choice)) {
                dataHandler = new CSVDataHandler(); // CSVを選択
            } else if ("2".equals(choice)) {
                dataHandler = new JSONDataHandler(); // JSONを選択
            } else {
                System.out.println("Invalid choice. Defaulting to CSV.");
                dataHandler = new CSVDataHandler(); // 不正な入力の場合はCSVを選択
            }

            // RecipeUIインスタンスを作成し、データハンドラーを渡す
            RecipeUI recipeUI = new RecipeUI(dataHandler);
            recipeUI.displayMenu(); // メインメニューを表示
            

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}