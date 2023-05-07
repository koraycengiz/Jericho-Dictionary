import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
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
        MenuItem editWord = new MenuItem("Edit Word");
        MenuItem editTranslation = new MenuItem("Edit Translation");
        MenuItem add = new MenuItem("Add");
        MenuItem about = new MenuItem("About");
        MenuItem support = new MenuItem("Support");


        //to create background

        HBox imageBox = new HBox();

        File newFile = new File("Jericho-design.png");

        Image backgroundImage = new Image(new FileInputStream(newFile.getAbsolutePath()));

        ImageView backgroundImageView = new ImageView(backgroundImage);
        imageBox.getChildren().addAll(backgroundImageView);


        imageBox.setAlignment(Pos.CENTER);
        HBox.setHgrow(imageBox, Priority.ALWAYS);


        BackgroundFill backgroundFill = new BackgroundFill(Color.CORAL, CornerRadii.EMPTY, Insets.EMPTY);

        Background background = new Background(backgroundFill);
        mainLayout.setBackground(background);

        ComboBox<String> LanguageBox = new ComboBox<>();


        FileManager fileManager = new FileManager();

        // Create a list to store the language pairs
        ArrayList<String> languagePairs = new ArrayList<>();

// Loop through all possible language pairs
        ArrayList <String> supportedLanguages = new ArrayList();
        supportedLanguages.add("eng");
        supportedLanguages.add("deu");
        supportedLanguages.add("fra");
        supportedLanguages.add("ell");
        supportedLanguages.add("ita");
        supportedLanguages.add("swe");
        supportedLanguages.add("tur");

        //to determine the available language pairs

        for (String sourceLanTag : supportedLanguages) {
            for (String targetLanTag : supportedLanguages) {
                // Skip if source and target languages are the same
                if (sourceLanTag.equals(targetLanTag)) {
                    continue;
                }

                // Construct the file path
                String filePath = "dictionaries\\" + sourceLanTag + "-" + targetLanTag + ".txt";

                // Check if the file exists
                File file = new File(filePath);
                if (file.exists()) {
                    // Add the language pair to the list
                    String languagePair = sourceLanTag + "-" + targetLanTag;
                    languagePairs.add(languagePair);
                }
            }
        }

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


                ScrollPane scrollPane = new ScrollPane();


                Label Title = new Label("Jericho Dictionary User Manual");
                Title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 18));


                String IntroTitle = "Introduction\n\n";
                String IntroText =
                        "Jericho Dictionary is an offline dictionary program that allows users to translate words from one language to another.\n" +
                        "The application does not require an internet connection and runs locally on your computer."+
                        "This user manual is created to explain the basic steps of using the program\n\n";

                String systemTitle = "System Requirements\n\n";
                String systemText =
                        "Jericho Dictionary is compatible with the following operating systems:\n" +
                        "Windows 10, 8, 7\n" +
                        "macOS 10.13 and later\n\n";

                String usageTitle = "Usage\n\n";

                String usageText =
                        "Translating Words:\n"+
                        "1.Launch the Offline Translation application.\n"+
                        "2.Enter the word you want to translate in the input box.\n"+
                        "3.Click on the 'Search' button.\n" +
                        "4.The translated words will be displayed in the output box.\n\n"+
                        "Adding Words to Dictionary:\n"+
                        "1.Launch the Offline Translation application.\n" +
                        "2.Click on the 'Add Word' button.\n" +
                        "3.Enter the word you want to add to the dictionary in the input box.\n" +
                        "4.Enter the translation of the word in the translation box.\n" +
                        "5.Select the source language and target language pairs from the drop-down menu.\n" +
                        "6.Click on the 'Add' button.\n" +
                        "If the word is added successfully, a message will be displayed.\n\n"+
                        "Editing the Words:\n\n";

                String languageTitle = "Supported Languages\n\n";

                String languageText =
                    "The Offline Translation application supports the following languages:\n" +
                        "\n" +
                        "English\n" +
                        "Turkish\n" +
                        "French\n" +
                        "German\n" +
                        "Italian\n" +
                        "Swedish\n" +
                        "Modern Greek\n\n";

                String troubleTitle = "Troubleshooting\n\n";
                String troubleText =
                        "If you encounter any issues while using the Offline Translation application, " +
                        "please contact our support team at hilalsinemsayar@gmail.com.\n\n";

                Text IntroTextNode = new Text(IntroText);
                Text IntroTitleNode = new Text(IntroTitle);
                Text SystemTextNode = new Text(systemText);
                Text SystemTitleNode = new Text(systemTitle);
                Text UsageTextNode = new Text(usageText);
                Text UsageTitleNode = new Text(usageTitle);
                Text LangTextNode = new Text(languageText);
                Text languageTitleNode = new Text(languageTitle);
                Text TroubleTextNode = new Text(troubleText);
                Text troubleTitleNode = new Text(troubleTitle);


                IntroTextNode.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 13));
                IntroTitleNode.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                SystemTextNode.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 13));
                SystemTitleNode.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                UsageTextNode.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 13));
                UsageTitleNode.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                LangTextNode.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 13));
                languageTitleNode.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));
                TroubleTextNode.setFont(Font.font("Times New Roman", FontWeight.NORMAL, 13));
                troubleTitleNode.setFont(Font.font("Times New Roman", FontWeight.BOLD, 15));

                vbox.getChildren().addAll(gp, Title, imageBox3, IntroTitleNode, IntroTextNode, SystemTitleNode, SystemTextNode, UsageTitleNode, UsageTextNode, languageTitleNode, LangTextNode, troubleTitleNode, TroubleTextNode);

                VBox.setVgrow(gp, Priority.ALWAYS);
                VBox.setVgrow(imageBox3, Priority.ALWAYS);
                VBox.setVgrow(IntroTextNode, Priority.ALWAYS);
                VBox.setVgrow(IntroTitleNode, Priority.ALWAYS);
                VBox.setVgrow(SystemTextNode, Priority.ALWAYS);
                VBox.setVgrow(SystemTitleNode, Priority.ALWAYS);
                VBox.setVgrow(UsageTextNode, Priority.ALWAYS);
                VBox.setVgrow(UsageTitleNode, Priority.ALWAYS);
                VBox.setVgrow(LangTextNode, Priority.ALWAYS);
                VBox.setVgrow(languageTitleNode, Priority.ALWAYS);
                VBox.setVgrow(TroubleTextNode, Priority.ALWAYS);
                VBox.setVgrow(troubleTitleNode, Priority.ALWAYS);
                VBox.setVgrow(scrollPane, Priority.ALWAYS);

                scrollPane.setContent(vbox);
                Scene scene = new Scene(scrollPane,400,400);
                stage.setScene(scene);
                stage.show();
            }
        });




        menu.getItems().addAll(about, support);
        action.getItems().addAll(editWord, editTranslation, add);
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
                stage.setTitle("add");

                VBox vbox = new VBox();
                vbox.setBackground(background4);
                Scene scene = new Scene(vbox);

                Label Title = new Label("Add Words");

                TextField WordField = new TextField();
                TextField translationField = new TextField();



                FileManager fileManager = new FileManager();


// Add the language pairs to the ComboBox
                LanguageBox.getItems().addAll(languagePairs);


                Label Word = new Label("Word");
                Label translation = new Label("Translation");
                Label Language = new Label("Source Language - Target Language");


                gp.add(Title, 1, 1);
                gp.add(Word, 0, 2);
                gp.add(WordField, 1, 2);
                gp.add(translation, 0, 3);
                gp.add(translationField, 1, 3);
                gp.add(Language, 0,4);
                gp.add(LanguageBox, 1,4);


                gp.setHgrow(Title, Priority.ALWAYS);
                gp.setHgrow(WordField, Priority.ALWAYS);
                gp.setHgrow(translationField, Priority.ALWAYS);
                gp.setHgrow(LanguageBox, Priority.ALWAYS);
                gp.setVgrow(gp, Priority.ALWAYS);

                Separator separator = new Separator();

                Button applyButton = new Button("Apply");

                applyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String wordSt = WordField.getText();
                        String translationSt = translationField.getText();
                        String LanSt = LanguageBox.getValue();


                        boolean isAdded = fileManager.addFile(wordSt, translationSt, "dictionaries\\"+LanSt+".txt");
                        if (isAdded) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setContentText("Word added to the dictionary!");
                            alert.showAndWait();
                            stage.close();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setContentText("The word already exists in the dictionary or the file doesn't exist for the selected languages!");
                            alert.showAndWait();
                        }
                        stage.close();
                    }
                });

                vbox.getChildren().addAll(gp,imageBox4, separator, applyButton);

                VBox.setVgrow(gp, Priority.ALWAYS);
                VBox.setVgrow(separator, Priority.NEVER);
                VBox.setVgrow(applyButton, Priority.NEVER);
                VBox.setVgrow(imageBox4, Priority.ALWAYS);

                stage.setScene(scene);
                stage.show();

            }
        });

        //edit actions
        editWord.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                GridPane gp = new GridPane();

                HBox imageBox5 = new HBox();
                ImageView backgroundImageView3 = new ImageView(backgroundImage);
                imageBox5.getChildren().addAll(backgroundImageView3);
                Background background4 = new Background(backgroundFill);
                gp.setBackground(background4);

                imageBox5.setAlignment(Pos.CENTER);
                HBox.setHgrow(imageBox5, Priority.ALWAYS);

                Label Title1 = new Label("Edit Word");

                Label oldWordlbl = new Label("Current Word");
                Label newWordlbl = new Label("New Word");

                TextField oldWordField = new TextField();
                TextField newWordField = new TextField();

                gp.setHgap(10);
                gp.setVgap(10);


                VBox.setMargin(imageBox5, new Insets(9));

                gp.setHgap(10); // Add some horizontal gap between nodes
                gp.setVgap(10); // Add some vertical gap between nodes

                Background background5 = new Background(backgroundFill);
                gp.setBackground(background5);

                Stage stage = new Stage();
                stage.setTitle("edit word");

                VBox vbox = new VBox();
                vbox.setBackground(background5);
                Scene scene = new Scene(vbox);

                FileManager fileManager = new FileManager();


// Add the language pairs to the ComboBox
                LanguageBox.getItems().addAll(languagePairs);


                Label Word = new Label(" Current Word");
                Label newWord = new Label("New Word");
                Label Language = new Label("Source Language - Target Language");


                gp.add(Title1, 1, 1);
                gp.add(oldWordlbl, 0, 2);
                gp.add(oldWordField, 1, 2);
                gp.add(newWordlbl, 0, 3);
                gp.add(newWordField, 1, 3);
                gp.add(Language, 0,4);
                gp.add(LanguageBox, 1,4);

                gp.setHgrow(Title1, Priority.ALWAYS);
                gp.setHgrow(oldWordField, Priority.ALWAYS);
                gp.setHgrow(newWordField, Priority.ALWAYS);
                gp.setHgrow(LanguageBox, Priority.ALWAYS);
                gp.setVgrow(gp, Priority.ALWAYS);

                Separator separator = new Separator();

                Button applyButton = new Button("Apply");

                applyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String oldWordFieldText = oldWordField.getText();
                        String newWordFieldText = newWordField.getText();
                        String LanSt = LanguageBox.getValue();


                        boolean isAdded = fileManager.updateHeadword(oldWordFieldText, newWordFieldText, "dictionaries\\"+LanSt+".txt");
                        if (isAdded) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setContentText("Word added to the dictionary!");
                            alert.showAndWait();
                            stage.close();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setContentText("The word already exists in the dictionary or the file doesn't exist for the selected languages!");
                            alert.showAndWait();
                        }
                        stage.close();
                    }
                });

                vbox.getChildren().addAll(gp,imageBox5, separator, applyButton);

                VBox.setVgrow(gp, Priority.ALWAYS);
                VBox.setVgrow(separator, Priority.NEVER);
                VBox.setVgrow(applyButton, Priority.NEVER);
                VBox.setVgrow(imageBox5, Priority.ALWAYS);

                stage.setScene(scene);
                stage.show();

            }
        });


        editTranslation.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                GridPane gp = new GridPane();

                HBox imageBox6 = new HBox();
                ImageView backgroundImageView5 = new ImageView(backgroundImage);
                imageBox6.getChildren().addAll(backgroundImageView5);
                Background background5 = new Background(backgroundFill);
                gp.setBackground(background5);

                imageBox6.setAlignment(Pos.CENTER);
                HBox.setHgrow(imageBox6, Priority.ALWAYS);

                Label Title1 = new Label("Edit Word");

                Label wordlbl = new Label("Current Word");
                Label newTranslationlbl = new Label("New Translation");

                TextField wordField = new TextField();
                TextField newTranslationField = new TextField();

                VBox.setMargin(imageBox6, new Insets(9));

                gp.setHgap(10); // Add some horizontal gap between nodes
                gp.setVgap(10); // Add some vertical gap between nodes

                Background background6 = new Background(backgroundFill);
                gp.setBackground(background6);

                Stage stage = new Stage();
                stage.setTitle("edit translation");

                VBox vbox = new VBox();
                vbox.setBackground(background6);
                Scene scene = new Scene(vbox);

                FileManager fileManager = new FileManager();
// Add the language pairs to the ComboBox
                LanguageBox.getItems().addAll(languagePairs);


                Label Word = new Label(" Current Word");
                Label newWord = new Label("New Word");
                Label Language = new Label("Source Language - Target Language");


                gp.add(Title1, 1, 1);
                gp.add(wordlbl, 0, 2);
                gp.add(wordField, 1, 2);
                gp.add(newTranslationlbl, 0, 3);
                gp.add(newTranslationField, 1, 3);
                gp.add(Language, 0,4);
                gp.add(LanguageBox, 1,4);

                gp.setHgrow(Title1, Priority.ALWAYS);
                gp.setHgrow(wordField, Priority.ALWAYS);
                gp.setHgrow(newTranslationField, Priority.ALWAYS);
                gp.setHgrow(LanguageBox, Priority.ALWAYS);
                gp.setVgrow(gp, Priority.ALWAYS);

                Separator separator = new Separator();

                Button applyButton = new Button("Apply");

                applyButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        String oldWordFieldText = wordField.getText();
                        String newTranslationFieldText = newTranslationField.getText();
                        String LanSt = LanguageBox.getValue();

                        boolean isAdded = fileManager.updateTranslation(oldWordFieldText, newTranslationFieldText, "dictionaries\\"+LanSt+".txt");
                        if (isAdded) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setContentText("Word added to the dictionary!");
                            alert.showAndWait();
                            stage.close();
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setContentText("The word already exists in the dictionary or the file doesn't exist for the selected languages!");
                            alert.showAndWait();
                        }
                        stage.close();
                    }
                });

                vbox.getChildren().addAll(gp,imageBox6, separator, applyButton);

                VBox.setVgrow(gp, Priority.ALWAYS);
                VBox.setVgrow(separator, Priority.NEVER);
                VBox.setVgrow(applyButton, Priority.NEVER);
                VBox.setVgrow(imageBox6, Priority.ALWAYS);

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
