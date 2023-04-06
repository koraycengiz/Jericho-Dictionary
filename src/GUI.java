import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {

        VBox mainLayout = new VBox();

        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Help");
        MenuItem about = new MenuItem("About");
        MenuItem support = new MenuItem("Support");
        support.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                GridPane gp = new GridPane();
                Stage stage = new Stage();
                Scene scene = new Scene(gp);
                stage.setTitle("contact");
                VBox vbox = new VBox();

                Label lblTitle = new Label("Contact Us");

                Label lblName = new Label("Name");
                TextField tfName = new TextField();

                Label lblSurname = new Label("Surname");
                TextField tfSurname = new TextField();

                Label lblEmail = new Label("Email");
                TextField tfEmail = new TextField();

                Label lblSelection = new Label("Reply Me");
                ObservableList<String> priorities = FXCollections.observableArrayList("via Email", "via Messages", "via Phone Call");
                ComboBox<String> cbSelection = new ComboBox<>(priorities);

                Label lblProblem = new Label("Problem");
                TextField tfProblem = new TextField();

                Label lblDescription = new Label("Description");
                TextArea taDescription = new TextArea();

                gp.add( lblTitle,       1, 1);  // empty item at 0,0
                gp.add( lblName,       0, 2); gp.add(tfName,        1, 2);
                gp.add( lblSurname,    0, 3); gp.add( tfSurname,    1, 3);
                gp.add( lblProblem,     0, 4); gp.add( tfProblem,     1, 4);
                gp.add( lblDescription, 0, 5); gp.add( taDescription, 1, 5);

                stage.setScene(scene);
                stage.show();

            }
        });

        menu.getItems().addAll(about,support);
        menuBar.getMenus().add(menu);
        root.setTop(menuBar);

        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);

        Label label = new Label("Source Language");

        //Languages
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("Turkish");
        choiceBox.getItems().add("English");
        choiceBox.getItems().add("German");
        choiceBox.getItems().add("Modern Greek");
        choiceBox.getItems().add("French");
        choiceBox.getItems().add("Italian");
        choiceBox.getItems().add("Swedish");

        HBox.setHgrow(label,Priority.ALWAYS);
        HBox.setHgrow(choiceBox,Priority.ALWAYS);

        HBox secondLine = new HBox(8);
        secondLine.setAlignment(Pos.CENTER);

        VBox.setMargin(firstLine,new Insets(8));

        firstLine.getChildren().addAll(label,choiceBox);

        Label word = new Label("Word:");
        TextField textField = new TextField();
        Button benjamin = new Button("Search");

        HBox.setHgrow(word,Priority.ALWAYS);
        HBox.setHgrow(textField,Priority.ALWAYS);
        HBox.setHgrow(benjamin,Priority.ALWAYS);

        VBox.setMargin(secondLine,new Insets(8));
        secondLine.getChildren().addAll(word,textField,benjamin);

        HBox thirdLine = new HBox(8);
        thirdLine.setAlignment(Pos.CENTER);

        ListView listview = new ListView();

        HBox.setHgrow(listview,Priority.ALWAYS);

        VBox.setMargin(thirdLine,new Insets(8));
        thirdLine.getChildren().addAll(listview);



        mainLayout.getChildren().addAll(root,firstLine,secondLine,thirdLine);

        BackgroundFill backgroundFill = new BackgroundFill(Color.PINK, CornerRadii.EMPTY,Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Dictionary Jericho");
        stage.setScene(scene);
        stage.show();
    }
}