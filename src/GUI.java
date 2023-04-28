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
import java.util.List;

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
                stage.setTitle("contact");
                VBox vbox = new VBox();
                VBox.setVgrow(gp, Priority.ALWAYS);
                Scene scene = new Scene(vbox);

                Label Title = new Label("Contact Us");

                Label Name = new Label("Name");
                Label Surname = new Label("Surname");
                Label Email = new Label("Email");
                Label Selection = new Label("Receive reply via ");
                Label Problem = new Label("Problem");
                Label Description = new Label("Description");

                TextField Nametf = new TextField();
                TextField Surnametf = new TextField();
                TextField Emailtf = new TextField();
                TextField Problemtf = new TextField();
                TextArea Descriptionta = new TextArea();

                ObservableList<String> options = FXCollections.observableArrayList("Email", "Messages", "Phone Call");
                ComboBox<String> Selectioncb = new ComboBox<>(options);

                gp.add(Title, 1, 1);
                gp.add(Name, 0, 2);
                gp.add(Nametf, 1, 2);
                gp.add(Surname, 0, 3);
                gp.add(Surnametf, 1, 3);
                gp.add(Email, 0,4);
                gp.add(Emailtf, 1,4);
                gp.add(Problem, 0, 5);
                gp.add(Problemtf, 1, 5);
                gp.add(Description, 0, 6);
                gp.add(Descriptionta, 1, 6);
                gp.add(Selection, 0,7);
                gp.add(Selectioncb, 1,7);

                Separator seperator = new Separator();

                ButtonBar buttons = new ButtonBar();

                Button sendButton = new Button("Send");
                Button closeButton = new Button("Close");

                buttons.getButtons().addAll(sendButton, closeButton);

                closeButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("closed"); // to test
                        stage.close();
                    }
                }); {

                }

                vbox.getChildren().addAll(gp, seperator, buttons);

                stage.setScene(scene);
                stage.show();

            }
        });

        menu.getItems().addAll(about, support);
        menuBar.getMenus().add(menu);
        root.setTop(menuBar);

        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);

        Label label = new Label("Source Language");



        ChoiceBox<String> choiceBox = new ChoiceBox<>(
                FXCollections.observableArrayList("eng", "deu", "tur", "fra", "ell", "swe", "ita"));
        choiceBox.getSelectionModel().selectFirst(); // Select English by default


        HBox.setHgrow(label, Priority.ALWAYS);
        HBox.setHgrow(choiceBox, Priority.ALWAYS);

        HBox secondLine = new HBox(8);
        secondLine.setAlignment(Pos.CENTER);

        VBox.setMargin(firstLine, new Insets(8));

        firstLine.getChildren().addAll(label, choiceBox);

        Label word = new Label("Word:");
        TextField textField = new TextField();
        Button benjamin = new Button("Search");




        //Search button's action
        Dictionary dict = new Dictionary();
        String textEntry = textField.getText();

        benjamin.setOnAction(Event -> dict.getTranslations(textEntry,choiceBox.getValue()));





        HBox.setHgrow(word, Priority.ALWAYS);
        HBox.setHgrow(textField, Priority.ALWAYS);
        HBox.setHgrow(benjamin, Priority.ALWAYS);

        VBox.setMargin(secondLine, new Insets(8));
        secondLine.getChildren().addAll(word, textField, benjamin);

        HBox thirdLine = new HBox(8);
        thirdLine.setAlignment(Pos.CENTER);


        //Listview's action
        ListView<String> listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        listView.setItems(items);



        benjamin.setOnAction(event -> {
            String searchedWord = textField.getText();
            String selectedLanguage = choiceBox.getValue();

            List<String> translations = dict.getTranslations(searchedWord,selectedLanguage);
            items.clear();
            items.addAll(translations);
        });





        HBox.setHgrow(listView, Priority.ALWAYS);

        VBox.setMargin(thirdLine, new Insets(8));
        thirdLine.getChildren().addAll(listView);


        mainLayout.getChildren().addAll(root, firstLine, secondLine, thirdLine);

        BackgroundFill backgroundFill = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);


        Scene scene = new Scene(mainLayout, 400, 300);
        stage.setTitle("Dictionary Jericho");
        stage.setScene(scene);
        stage.show();
    }


}
