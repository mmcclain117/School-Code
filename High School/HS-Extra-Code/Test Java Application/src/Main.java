
import java.io.File;
import static java.lang.System.out;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Master
 */
public final class Main extends Application {

//    private Desktop desktop = Desktop.getDesktop();
    public File startFile;
    public int stageInt;

    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser");

        final FileChooser fileChooser = new FileChooser();
        final DirectoryChooser fr = new DirectoryChooser();

        final Button openButton = new Button("C Drive");
        final Button openMultipleButton = new Button("Select a Folder");

        openButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                startFile = new File("C:\\");
                out.println(startFile.getAbsolutePath());
            }
        });

        openMultipleButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                startFile = fr.showDialog(stage);
                out.println(startFile.getAbsolutePath());
            }
        });

        final Button ok = new Button("OK");
        final Button cancel = new Button("Cancel");
        boolean compareRun = false;

        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                stageInt++;
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent e) {
                startFile = new File("");
            }
        });

        final GridPane inputGridPane = new GridPane();

        GridPane.setConstraints(openButton, 0, 0);
        GridPane.setConstraints(openMultipleButton, 1, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);

        GridPane.setConstraints(cancel, 1, 1);
        GridPane.setConstraints(ok, 2, 1);
        inputGridPane.add(cancel, 1, 1);
        inputGridPane.add(ok, 1, 2);

        inputGridPane.getChildren().addAll(openButton, openMultipleButton);

        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));

        stage.setScene(new Scene(rootGroup));
        stage.show();
    }

    /**
     * The second stage in the set that shows the progress of where we are at in
     * the comparison part
     *
     * @param stage
     */
    public void Sec(Stage stage) {

    }

    /**
     * This is the third stage with the selection on if there is one any
     * avalible
     *
     * @param stage
     */
    public void third(Stage stage) {

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
