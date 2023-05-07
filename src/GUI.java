import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
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
        Menu action = new Menu("Actions");
        MenuItem edit = new MenuItem("Edit");
        MenuItem add = new MenuItem("Add");
        MenuItem about = new MenuItem("About");
        MenuItem support = new MenuItem("Support");


        //to create background

        HBox imageBox = new HBox();

        Image backgroundImage = new Image("C:\\Users\\Koray\\Desktop\\Jericho-design-china-name.png");

        ImageView backgroundImageView = new ImageView(backgroundImage);
        imageBox.getChildren().addAll(backgroundImageView);


        imageBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(imageBox, Priority.ALWAYS);


        BackgroundFill backgroundFill = new BackgroundFill(Color.CORAL, CornerRadii.EMPTY, Insets.EMPTY);

        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);

        support.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                HBox imageBox2 = new HBox();
                ImageView backgroundImageView2 = new ImageView(backgroundImage);
                imageBox2.getChildren().addAll(backgroundImageView2);

                imageBox2.setAlignment(Pos.CENTER);
                HBox.setHgrow(imageBox2, Priority.ALWAYS);


                VBox.setMargin(imageBox2, new Insets(8));
                GridPane gp = new GridPane();
                gp.setHgap(10); // Add some horizontal gap between nodes
                gp.setVgap(10); // Add some vertical gap between nodes

                Background background2 = new Background(backgroundFill);
                gp.setBackground(background2);

                Stage stage = new Stage();
                stage.setTitle("contact");

                VBox vbox = new VBox();
                vbox.setBackground(background2);
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

                // Make the gridpane fill the available width and height
                gp.setHgrow(Title, Priority.ALWAYS);
                gp.setHgrow(Nametf, Priority.ALWAYS);
                gp.setHgrow(Surnametf, Priority.ALWAYS);
                gp.setHgrow(Emailtf, Priority.ALWAYS);
                gp.setHgrow(Problemtf, Priority.ALWAYS);
                gp.setHgrow(Descriptionta, Priority.ALWAYS);
                gp.setHgrow(Selectioncb, Priority.ALWAYS);
                gp.setVgrow(gp, Priority.ALWAYS);

                Separator separator = new Separator();

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
                });

                vbox.getChildren().addAll(gp, imageBox2, separator, buttons);

                // Make the vbox fill the available width and height
                VBox.setVgrow(gp, Priority.ALWAYS);
                VBox.setVgrow(separator, Priority.NEVER);
                VBox.setVgrow(buttons, Priority.NEVER);
                VBox.setVgrow(imageBox2, Priority.ALWAYS);

                stage.setScene(scene);
                stage.show();

            }
        });

        about.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {

                HBox imageBox3 = new HBox();
                ImageView backgroundImageView2 = new ImageView(backgroundImage);
                imageBox3.getChildren().addAll(backgroundImageView2);

                imageBox3.setAlignment(Pos.CENTER);
                HBox.setHgrow(imageBox3, Priority.ALWAYS);


                VBox.setMargin(imageBox3, new Insets(8));
                GridPane gp = new GridPane();
                gp.setHgap(10); // Add some horizontal gap between nodes
                gp.setVgap(10); // Add some vertical gap between nodes


                Stage stage = new Stage();
                stage.setTitle("Manual");

                VBox vbox = new VBox();
                Scene scene = new Scene(vbox);

                Label Title = new Label("Jericho Dictionary User Manual");
                Title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));


                String IntroText = "Introduction\n\n" +
                        "Jericho Dictionary is an offline dictionary program that allows users to translate words from one language to another.\n" +
                        "This user manual is created to explain the basic steps of using the program";

                String systemText = "System Requirements\n\n" +
                        "Jericho Dictionary is compatible with the following operating systems:" +
                        "Windows 10, 8, 7" +
                        "macOS 10.13 and later";

                Text manualTextNode = new Text(IntroText);
                manualTextNode.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 18));

                vbox.getChildren().addAll(gp, Title, imageBox3, manualTextNode);

                stage.setScene(scene);
                stage.show();
            }
        });



        menu.getItems().addAll(about, support);
        action.getItems().addAll(edit, add);
        menuBar.getMenus().add(menu);
        menuBar.getMenus().add(action);

        root.setTop(menuBar);

        HBox firstLine = new HBox(8);
        firstLine.setAlignment(Pos.CENTER);

        Label label = new Label("Source Language");


        HBox.setHgrow(label, Priority.ALWAYS);


        HBox secondLine = new HBox(8);
        secondLine.setAlignment(Pos.CENTER);

        VBox.setMargin(firstLine, new Insets(8));



        Label word = new Label("Word:");
        TextField textField = new TextField();
        Button benjamin = new Button("Search");

        //add actions
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                GridPane gp = new GridPane();

                HBox imageBox4 = new HBox();
                ImageView backgroundImageView3 = new ImageView(backgroundImage);
                imageBox4.getChildren().addAll(backgroundImageView3);

                imageBox4.setAlignment(Pos.CENTER);
                HBox.setHgrow(imageBox4, Priority.ALWAYS);


                VBox.setMargin(imageBox4, new Insets(9));

                gp.setHgap(10); // Add some horizontal gap between nodes
                gp.setVgap(10); // Add some vertical gap between nodes

                Background background4 = new Background(backgroundFill);
                gp.setBackground(background4);

                Stage stage = new Stage();
                stage.setTitle("edit");

                VBox vbox = new VBox();
                vbox.setBackground(background4);
                Scene scene = new Scene(vbox);

                Label Title = new Label("Add Words");

                Label oldWord = new Label("Old Word");
                Label newWord = new Label("New Word");
                Label definition = new Label("Definition");

                TextField oldWordField = new TextField();
                TextField newWorldField = new TextField();
                TextField defField = new TextField();

                gp.add(Title, 1, 1);
                gp.add(oldWord, 0, 2);
                gp.add(oldWordField, 1, 2);
                gp.add(newWord, 0, 3);
                gp.add(newWorldField, 1, 3);
                gp.add(definition, 0,4);
                gp.add(defField, 1,4);

                gp.setHgrow(Title, Priority.ALWAYS);
                gp.setHgrow(oldWordField, Priority.ALWAYS);
                gp.setHgrow(newWorldField, Priority.ALWAYS);
                gp.setHgrow(defField, Priority.ALWAYS);
                gp.setVgrow(gp, Priority.ALWAYS);

                Separator separator = new Separator();

                ButtonBar buttons = new ButtonBar();

                Button applyButton = new Button("Apply");

                buttons.getButtons().addAll(applyButton);

                applyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("closed"); // to test
                        stage.close();
                    }
                }); {

                }

                vbox.getChildren().addAll(gp,imageBox4, separator, buttons);

                VBox.setVgrow(gp, Priority.ALWAYS);
                VBox.setVgrow(separator, Priority.NEVER);
                VBox.setVgrow(buttons, Priority.NEVER);
                VBox.setVgrow(imageBox4, Priority.ALWAYS);

                stage.setScene(scene);
                stage.show();

            }
        });


        //edit actions
        edit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                GridPane gp = new GridPane();

                HBox imageBox5 = new HBox();
                //Image backgroundImage3 = new Image("C:\\Users\\Koray\\Desktop\\Jericho-design-china-name.png");
                ImageView backgroundImageView3 = new ImageView(backgroundImage);
                imageBox5.getChildren().addAll(backgroundImageView3);

                imageBox5.setAlignment(Pos.CENTER);
                HBox.setHgrow(imageBox5, Priority.ALWAYS);


                VBox.setMargin(imageBox5, new Insets(9));

                gp.setHgap(10); // Add some horizontal gap between nodes
                gp.setVgap(10); // Add some vertical gap between nodes

                Background background4 = new Background(backgroundFill);
                gp.setBackground(background4);

                Stage stage = new Stage();
                stage.setTitle("edit");

                VBox vbox = new VBox();
                vbox.setBackground(background4);
                Scene scene = new Scene(vbox);

                Label Title = new Label("Edit Words");

                Label oldWord = new Label("The word you will edit");
                Label newWord = new Label("New Word");
                Label definition = new Label("Definition");

                TextField oldWordField = new TextField();
                TextField newWorldField = new TextField();
                TextField defField = new TextField();

                gp.add(Title, 1, 1);
                gp.add(oldWord, 0, 2);
                gp.add(oldWordField, 1, 2);
                gp.add(newWord, 0, 3);
                gp.add(newWorldField, 1, 3);
                gp.add(definition, 0,4);
                gp.add(defField, 1,4);

                gp.setHgrow(Title, Priority.ALWAYS);
                gp.setHgrow(oldWordField, Priority.ALWAYS);
                gp.setHgrow(newWorldField, Priority.ALWAYS);
                gp.setHgrow(defField, Priority.ALWAYS);
                gp.setVgrow(gp, Priority.ALWAYS);

                Separator separator = new Separator();

                ButtonBar buttons = new ButtonBar();

                Button applyButton = new Button("Apply");

                buttons.getButtons().addAll(applyButton);

                applyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println("closed"); // to test
                        stage.close();
                    }
                }); {

                }

                vbox.getChildren().addAll(gp,imageBox5, separator, buttons);
                VBox.setVgrow(separator, Priority.NEVER);
                VBox.setVgrow(buttons, Priority.NEVER);
                VBox.setVgrow(imageBox5, Priority.ALWAYS);

                stage.setScene(scene);
                stage.show();

            }
        });


        //Search button's action
        Dictionary dict = new Dictionary();
        String textEntry = textField.getText();


        HBox.setHgrow(word, Priority.ALWAYS);
        HBox.setHgrow(textField, Priority.ALWAYS);
        HBox.setHgrow(benjamin, Priority.ALWAYS);

        VBox.setMargin(secondLine, new Insets(8));
        secondLine.getChildren().addAll(word, textField, benjamin);

        HBox thirdLine = new HBox(7);
        thirdLine.setAlignment(Pos.CENTER);


        //Listview's action
        ListView<String> listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList();
        listView.setItems(items);



        benjamin.setOnAction(event -> {
            String searchedWord = textField.getText();


            List<ArrayList<String>> translations = dict.getTranslations(searchedWord);
            items.clear();
            for (ArrayList<String> translation:translations) {
                items.addAll(translation);
            }
        });


        HBox.setHgrow(listView, Priority.ALWAYS);

        VBox.setMargin(imageBox, new Insets(9));
        VBox.setMargin(thirdLine, new Insets(10));
        thirdLine.getChildren().addAll(listView);

        mainLayout.getChildren().addAll(root, firstLine, secondLine, imageBox, thirdLine);

        Scene scene = new Scene(mainLayout, 800, 600);
        stage.setTitle("Dictionary Jericho");
        stage.setScene(scene);
        stage.show();
    }

}
