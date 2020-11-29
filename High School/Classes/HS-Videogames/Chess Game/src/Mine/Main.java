package Mine;

/*
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;
import javax.swing.table.AbstractTableModel;
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
import javax.swing.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Master Ward
 */
public class Main extends JFrame implements Runnable, MouseListener, MouseMotionListener, ActionListener, ChangeListener {

    public static Chess chess;

    // Dimensions that need to be changed
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 1000;
    public static final char TILE_WIDTH = 50;
    public static final char TILE_HEIGHT = 50;
    public static final int BOARD_WIDTH = TILE_WIDTH * 8;
    public static final int BOARD_HEIGHT = TILE_HEIGHT * 8;
    public static final int TAB_WIDTH = 290;
    public static final int TAB_HEIGHT = 440;

    // Offsets
    public static int HORZ_OFFSET = 3;
    public static int VERT_OFFSET = 100;
    public static final int BOARD_HORZ_OFFSET = 0;
    public static final int BOARD_VERT_OFFSET = 100;
    private Image offScreen;

    private boolean bRedraw = true; // the board will be redrawn when this is true
    int moveTime = 0;

    private JTabbedPane tabbedPane;

    /**
     *
     */
    public Graph graph = new Graph(); // Need the Graph Class
    private JScrollPane graphScroll = new JScrollPane(graph);
    JSlider difficultySlider = new JSlider(1, 6, Chess.maxDepth);
    Vector moveList = new Vector();

    TableModel moveTable_dataModel = new AbstractTableModel() {

        public int getColumnCount() {
            return 3;
        }

        public int getRowCount() {
            if (moveList.size() == 1) {
                return 1;
            }
            return moveList.size() / 2 + moveList.size() % 2;
        }

        public Object getValueAt(int row, int col) {
            if (moveList.size() > 0) {
                if (col == 0) {
                    Integer r = row + 1;
                    return (Object) r;
                }

                int i = row * 2;
                if (col == 2) {
                    ++i;
                }
                if (moveList.size() > i) {
                    return moveList.get(i);
                }
            }
            return new String();
        }
    };

    JTable moveTable = new JTable(moveTable_dataModel);
    JScrollPane moveTable_scrollPane = new JScrollPane(moveTable);

    static Image[] toolbarImages = new Image[6];

    JButton butt_NewGame;
    JButton butt_LoadGame;
    JButton butt_SaveGame;
    JButton butt_Takeback;
    JButton butt_SetupBoard;
    JButton butt_Help;
    Panel toolPanel;

    JMenuBar menuBar;
    JMenu menu_Game;
    JMenuItem menu_Game_New;
    JMenuItem menu_Game_SetPosition;
    JMenuItem menu_Game_Takeback;
    JMenuItem menu_Game_Save;
    JMenuItem menu_Game_Load;
    JMenuItem menu_Game_Exit;
    JMenu menu_Options;
    JMenuItem menu_Opt_Database;
    JMenu menu_Network;
    JMenuItem menu_Network_Host;
    JMenuItem menu_Network_Connect;
    JMenu menu_View;
    JMenuItem menu_View_Flip;

    java.util.Timer timer = new java.util.Timer();
    static AICaller aiCaller; // Need to make the class
    static int hoverPiece = 0;
    static int mouse_x = 0, mouse_y = 0;
    public boolean bPlaying = true; // are we playing
    public boolean bQuit = false;
    public static boolean bSetPosition = false;
    MediaTracker tracker;
    static int trackerCount = 0;
    public static Image strip;
    public static Image images[];
    int num_images = 0;
    int piece_width = 50;
    int height;

    JLabel field_Nodes = new JLabel("0");
    JLabel field_NodesSecond = new JLabel("0");
    JLabel field_Depth = new JLabel("0");
    JLabel field_Score = new JLabel("0");
    JLabel field_Thinking = new JLabel();
    JLabel field_MoveTime = new JLabel("0 seconds");
    JRadioButton radio_White = new JRadioButton("Play as White", true);
    JRadioButton radio_Black = new JRadioButton("Play as Black");
    ButtonGroup radioGroup = new ButtonGroup();
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));
    JCheckBox chk_VisualThinking = new JCheckBox("Visual Thinking (affects performance)", true);
    static boolean bVisualThinking = true;
    JCheckBox chk_SlowRedraws = new JCheckBox("Slow Redraws (better performance)", false);
    static boolean bSlowRedraws = false;
    JCheckBox chk_IterativeDeep = new JCheckBox("Iterative Deepening (prunes search tree)", true);
    Panel infoPanel;
    static boolean bFlipBoard = true;

    public void alert(String title, String message) {
        String[] SaveOptionNames = {"Continue"};
        JLabel label = new JLabel(message);
        JOptionPane.showOptionDialog(this, label, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, SaveOptionNames, SaveOptionNames[0]);
    }

    public void extractImages(Image strip, Image images[], int num_images, int width, int height) {
        ImageProducer source = strip.getSource();
        for (int i = 0; i < num_images; i++) {
            // define filter to pull image at (i*width,0) with
            // dimensions (width,height)

            ImageFilter extractFilter = new CropImageFilter(i * width, 0, width, height);
            // define producer from source and filter
            ImageProducer producer = new FilteredImageSource(source, extractFilter);
            // extract the subimage!
            images[i] = createImage(producer);
        }
        try {
//            images[0] = ImageIO.read(new File("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\Pieces\\pawn.jpg"));
            images[0] = ImageIO.read(new File("images\\Pieces\\pawn.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    int calcSquare(int mx, int my) {
        int sx = mx / TILE_WIDTH;
        int sy = my / TILE_HEIGHT;

        if (mx < 0 || my < 0 || sx >= 8 || sy >= 8) {
            return -1;
        }

        return (bFlipBoard ? (7 - sy) * 10 + (7 - sx) : sy * 10 + sx);
    }

    public int Exit() {
        dispose();
        System.exit(0);
        return 0;
    }

    public static ChessMove lastMove = new ChessMove();

    public void playerMoved(boolean player, ChessMove move) {
        // test to enable en-passant
        if (Chess.pos.board[move.from] == (player ? ChessPosition.PAWN : -ChessPosition.PAWN)) {
            int offset = move.to - move.from;
            if (offset < 0) {
                offset = -offset;
            }
            if (offset == 20) // i.e. moved two square
            {

                Chess.pos.enPassantSquare = move.to;
            }
        } else {
            Chess.pos.enPassantSquare = 0;
        }
        // adding previous position to the board history
        ChessPosition p = new ChessPosition(Chess.pos);
        Chess.boardHistory.push(p);
        ChessPosition checkPos = new ChessPosition(p);
        checkPos.bBlackChecked = false;
        checkPos.bWhiteChecked = false;
        checkPos.makeMove(move);
        chess.calcPossibleMoves(checkPos, player);
//Do some checkmate testing
        if (!bSetPosition) {
            if (player == Chess.BLACK && checkPos.bBlackChecked) {
                Chess.bThinking = false;
                alert("Checkmate", "Black is checkmated.");
            } else if (player == Chess.WHITE && checkPos.bWhiteChecked) {
                Chess.bThinking = false;
                alert("Checkmate", "White is checkmated.");
            }
        }
        lastMove = move;
        // add the move to our move list
        moveList.add(move.toString());
        moveTable_scrollPane.getViewport().updateUI();
        moveTime = 0;
        if (player == Chess.PROGRAM) {
            Graph.data.add(Chess.bestMoveEval);
            graph.repaint();
        }
        if (Chess.bestMoveEval >= 1000.0f) {
            field_Score.setText("Mate in " + (int) (Chess.maxDepth - 1 - (int) (Chess.bestMoveEval / 1000.0f) / 2));
        } else if (Chess.bestMoveEval <= -1000.0f) {
            field_Score.setText("Mate in " + (int) (Chess.maxDepth - 1 - (Chess.bestMoveEval / -1000.0f) / 2));
        } else {
            field_Score.setText(Float.toString(Chess.bestMoveEval));
        }
        chess.bWhoseTurn = !player;
        /**
         * We are not repainting, since the auto-painter thread will
         * auto-refresh our fields
         */
        bRedraw = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        while (true) {
            // Easy Error Checking
            if (hoverPiece > 0 && !Chess.bThinking) {
                int x = e.getX() - HORZ_OFFSET; // - BOARD_HORZ_OFFSET;
                int y = e.getY() - VERT_OFFSET; // - BOARD_VERT_OFFSET;
                if (x <= BOARD_WIDTH && y <= BOARD_HEIGHT) {
                    int square = calcSquare(x, y);
                    if (square + 1 != hoverPiece) {
                        // Now we must test whether this move is valid
                        ChessMove move = new ChessMove();
                        move.from = hoverPiece - 1;
                        move.to = square;
                        if (bPlaying) {
                            if (!chess.isValidMove(Chess.pos, move)) {
                                break;
                            }
                        }
                        playerMoved(Chess.HUMAN, move);
                        Chess.pos.makeMove(move);
                        // This is the queue for the PC to start THINKING...
                        if (bPlaying) {
                            aiCaller.go();
                        }
                    }
                }
            }
            break;
        }
        hoverPiece = 0;
        bRedraw = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() - HORZ_OFFSET; // ..BOARD_HORZ_OFFSET;
        int y = e.getY() - VERT_OFFSET; // BOARD_VERT_OFFSET;
        if (x <= BOARD_WIDTH && y <= BOARD_HEIGHT) {
            int square = calcSquare(x, y);
            if (square >= 0 && square <= 80) {
                if (Chess.pos.board[square] != ChessPosition.BLANK) {
                    if (bSetPosition || (Chess.HUMAN ? (Chess.pos.board[square] > 0) : (Chess.pos.board[square] < 0))) {
                        hoverPiece = square + 1;
                    } else {
                        hoverPiece = 0;
                    }
                }
            }
        } else {
            hoverPiece = 0;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == difficultySlider) {
            Chess.maxDepth = difficultySlider.getValue();
        }
    }

//    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == menu_Game_New || source == butt_NewGame) {
            NewGame();
        } else if (source == menu_Game_Takeback || source == butt_Takeback) {
            lastMove = new ChessMove();
            chess.Takeback();
            if (moveList.size() > 0) {
                moveList.removeElementAt(moveList.size() - 1);
            }
            if (Chess.bThinking) {
                Chess.bThinking = false;
            } else {
                chess.Takeback();
                if (moveList.size() > 0) {
                    moveList.removeElementAt(moveList.size() - 1);
                }
                if (Graph.data.size() > 0) {
                    Graph.data.removeElementAt(graph.data.size() - 1);
                }
            }
            repaint();
        } else // Menu stuff
        {
            if (source == menu_Game_SetPosition || source == butt_SetupBoard) {
                if (bSetPosition) {
                    // Saving
                    menu_Game_SetPosition.setLabel("Set-Up Position");
                } else {
                    menu_Game_SetPosition.setLabel("Save Position");
                }
                SetupBoard();
            } else if (source == menu_Game_Load || source == butt_LoadGame) {
                LoadGame();
            } else if (source == menu_Game_Save || source == butt_SaveGame) {
                SaveGame();
            } else if (source == butt_Help) {
//                ShowHelpDialog();
            } else if (source == menu_Game_Exit) {
                System.out.println("#Test to save game here!");
                Exit();
            } else if (source == chk_VisualThinking) {
                bVisualThinking = ((JCheckBox) source).isSelected();//!bVisualThinking;
            } else if (source == chk_SlowRedraws) {
                bSlowRedraws = ((JCheckBox) source).isSelected();
            } else if (source == radio_White) {
                if (Chess.bThinking) {
                    Chess.bThinking = false;
                }
                Chess.HUMAN = Chess.WHITE;
                Chess.PROGRAM = Chess.BLACK;
                bFlipBoard = true;
                if (chess.bWhoseTurn == Chess.PROGRAM) {
                    aiCaller.go();
                }
            } else if (source == radio_Black) {
                if (Chess.bThinking) {
                    Chess.bThinking = false;
                }
                Chess.HUMAN = Chess.BLACK;
                Chess.PROGRAM = Chess.WHITE;
                bFlipBoard = false;
                if (moveList.isEmpty() || chess.bWhoseTurn == Chess.PROGRAM) {
                    aiCaller.go();
                }
            }
        }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouse_x = e.getX();
        mouse_y = e.getY();
        if (hoverPiece != 0) {
            bRedraw = true;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse_x = e.getX();
        mouse_y = e.getY();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void LoadImages() {
        System.out.println("init() called");
        tracker = new MediaTracker(this);
//        Toolkit t = new Toolkit();
//        Image strip = Toolkit.getDefaultToolkit().getImage("../images/alpha.gif");
//        Image strip = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\alpha.gif");
        Image strip = Toolkit.getDefaultToolkit().getImage("E:\\Project\\Chess Game\\images\\alpha.gif");
        tracker.addImage(strip, 0);
        ++trackerCount;
//        toolbarIm//ages[0] = Toolkit.getDefaultToolkit().getImage("../images/icon_new.gif");
//        toolbarImages[0] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\icon_new.gif");
        toolbarImages[0] = Toolkit.getDefaultToolkit().getImage("E:\\Project\\Chess Game\\images\\icon_new.gif");
//        toolbarImages[1] = Toolkit.getDefaultToolkit().getImage("../images/icon_loadgame.gif");
//        toolbarImages[1] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\icon_loadgame.gif");
        toolbarImages[1] = Toolkit.getDefaultToolkit().getImage("E:\\Project\\Chess Game\\images\\icon_loadgame.gif");
//        toolbarImages[2] = Toolkit.getDefaultToolkit().getImage("../images/icon_savegame.gif");
//        toolbarImages[2] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\icon_savegame.gif");
        toolbarImages[2] = Toolkit.getDefaultToolkit().getImage("E:\\Project\\Chess Game\\images\\icon_savegame.gif");
//        toolbarImages[3] = Toolkit.getDefaultToolkit().getImage("../images/icon_takeback.gif");
//        toolbarImages[3] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\icon_takeback.gif");
        toolbarImages[3] = Toolkit.getDefaultToolkit().getImage("E:\\Project\\Chess Game\\images\\icon_takeback.gif");
//        toolbarImages[4] = Toolkit.getDefaultToolkit().getImage("../images/icon_setupboard.gif");
//        toolbarImages[4] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\icon_setupboard.gif");
        toolbarImages[4] = Toolkit.getDefaultToolkit().getImage("E:\\Project\\Chess Game\\images\\icon_setupboard.gif");
//        toolbarImages[5] = Toolkit.getDefaultToolkit().getImage("../images/icon_help.gif");
//        toolbarImages[5] = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jacob Ward\\Dropbox\\Netbeans Project\\Chess Game\\images\\icon_help.gif");
        toolbarImages[5] = Toolkit.getDefaultToolkit().getImage("E:\\Project\\Chess Game\\images\\icon_help.gif");
        for (int i = 0; i < 6; i++) {
            tracker.addImage(toolbarImages[i], trackerCount++);
        }
        try {
            System.out.println("Loading images...");
            tracker.waitForAll();
        } catch (InterruptedException e) {
            System.out.println("There was an error loading the piece image strip.");
            return;
        }
        // Load Piece Images for Black & White from an image strip
        // define number of images in strip
        num_images = strip.getWidth(this) / piece_width;
        System.out.println(num_images + " in strip");
        // define height of each image
        height = strip.getHeight(this);
        // define array of constituent images
        images = new Image[num_images];
        // extract constituent images
        extractImages(strip, images, num_images, piece_width, height);
        // Track the loading of images with MediaTracker
        for (int i = 0; i < num_images; i++) {
            tracker.addImage(images[i], trackerCount++);
        }
        try {
            System.out.println("Loading images, please wait...");
            tracker.waitForAll();
        } catch (InterruptedException e) {
            System.out.println("There was an error loading a piece's image file.");
//            return;
        }
    }

    static class OldGame {

        int id; // all important!
        String desc;
        String szDate;
        ChessPosition pos;
    }

    Vector loadGames = new Vector();
    TableModel gameTable_dataModel = new AbstractTableModel() {

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public int getRowCount() {
            return loadGames.size();
        }

        public Object getValueAt(int row, int col) {
            Main.OldGame og = (Main.OldGame) loadGames.get(row);
            switch (col) {
                case 0:
                    return og.desc;
                case 1:
                    return og.szDate;
            }
            return new String();
        }
    };
    JTable gameTable = new JTable(gameTable_dataModel);
    JScrollPane gameTable_scrollPane = new JScrollPane(gameTable);
    Button dlgButt_LoadGame = new Button("Load Game");
    JDialog dialog;

    public void LoadGame() {
        dialog = new JDialog(this, "Load Game", true);
        dialog.setSize(600, 320);
        dialog.setResizable(false);
        gameTable.getColumnModel().getColumn(0).setHeaderValue("Game Description");
        gameTable.getColumnModel().getColumn(1).setHeaderValue("Date");
        Container con = dialog.getContentPane();
        populateLoadGames();
        gameTable.getTableHeader().setReorderingAllowed(false);
        con.setLayout(null);
        gameTable_scrollPane.setBounds(0, 0, 600, 250);
        gameTable.setBounds(0, 0, 600, 250);
        con.add(gameTable_scrollPane);
        dlgButt_LoadGame.setBounds(0, 250, 200, 40);
        con.add(dlgButt_LoadGame);
        dlgButt_LoadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = gameTable.getSelectedRow();
                if (index == -1) {
                    return;
                }
                OldGame og = (OldGame) loadGames.get(index);
                NewGame();
                Chess.main.setTitle(og.desc);
                Chess.pos = new ChessPosition(og.pos);
                chess.bWhoseTurn = Chess.HUMAN;
                dialog.dispose();
            }
        });
        Button dlgButt_Delete = new Button("Delete");
        dlgButt_Delete.setBounds(200, 250, 200, 40);
        dlgButt_Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = gameTable.getSelectedRow();
                if (index < 0) {
                    return;
                }
                OldGame og = (OldGame) loadGames.get(index);
                populateLoadGames();
                gameTable.repaint();
                System.out.println("Deleted game from database.");
            }
        });
        con.add(dlgButt_Delete);
        Button dlgButt_Close = new Button("Close");
        dlgButt_Close.setBounds(400, 250, 200, 40);
        dlgButt_Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        con.add(dlgButt_Close);
        dialog.show();
    }

    int populateLoadGames() {
        System.out.println("#populateLoadGames() success");
        return 0;
    }
    static String[] SaveOptionNames = {"Save", "Cancel"};
    static String SaveTitle = "Save Game";

    public void SaveGame() {
        JLabel gameDescLabel = new JLabel("Game Description: ", JLabel.RIGHT);
        JTextField gameDescField;
        gameDescField = new JTextField(getTitle());
        JPanel savePanel = new JPanel(false);
        savePanel.setLayout(new BoxLayout(savePanel, BoxLayout.X_AXIS));
        JPanel namePanel = new JPanel(false);
        namePanel.setLayout(new GridLayout(1, 1));
        namePanel.add(gameDescLabel);
        JPanel fieldPanel = new JPanel(false);
        fieldPanel.setLayout(new GridLayout(1, 1));
        fieldPanel.add(gameDescField);
        savePanel.add(namePanel);
        savePanel.add(fieldPanel);
        if (JOptionPane.showOptionDialog(this, savePanel, SaveTitle, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, SaveOptionNames, SaveOptionNames[0]) == 0) {
            String szPos = Chess.encodePosition(Chess.pos);
            setTitle(gameDescField.getText());
            System.out.println("Game saved.");
        }
    }

    public void SetupBoard() {
        bSetPosition = !bSetPosition;
        bPlaying = !bSetPosition;
    }

    public void NewGame() {
        lastMove = new ChessMove();
        chess.bThinking = false;
        chess.NewGame();
        moveList.clear();
        moveTable.repaint();
        graph.data.clear();
        graph.repaint();
        if (chess.PROGRAM == chess.WHITE) {
            aiCaller.go();
        }
    }

    static String tempString;

    public Main() {
        thisMain = this;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Exit();
            }
        });
//        this.addMouseListener(this);
        thisMain.addMouseListener(this);
//        this.addMouseMotionListener(this);
        thisMain.addMouseMotionListener(this);
//        this.setResizable(false);
        thisMain.setResizable(false);

        LoadImages(); // Initialises Everything

        Container con = getContentPane();
        con.setLayout(null); // We don't want a layout as we'd rather arrange components ourselves

        toolPanel = new Panel(new GridLayout(1, 6));
        toolPanel.setBounds(0, 0, BOARD_WIDTH + HORZ_OFFSET + 10, 40);

        butt_NewGame = new JButton(new ImageIcon(toolbarImages[0]));
        butt_NewGame.addActionListener(this);
        toolPanel.add(butt_NewGame);

        butt_LoadGame = new JButton(new ImageIcon(toolbarImages[1]));
        butt_LoadGame.addActionListener(this);
        toolPanel.add(butt_LoadGame);

        butt_SaveGame = new JButton(new ImageIcon(toolbarImages[2]));
        butt_SaveGame.addActionListener(this);
        toolPanel.add(butt_SaveGame);

        butt_Takeback = new JButton(new ImageIcon(toolbarImages[3]));
        butt_Takeback.addActionListener(this);
        toolPanel.add(butt_Takeback);

        butt_SetupBoard = new JButton(new ImageIcon(toolbarImages[4]));
        butt_SetupBoard.addActionListener(this);
        toolPanel.add(butt_SetupBoard);

        butt_Help = new JButton(new ImageIcon(toolbarImages[5]));
        butt_Help.addActionListener(this);
        toolPanel.add(butt_Help);

        con.add(toolPanel);

        // Init Menu Bar
        menuBar = new JMenuBar();

        menu_Game = new JMenu("Game");
        menuBar.add(menu_Game);

        // Init Save Game Menu
        menu_Game_New = new JMenuItem("New Game");
        menu_Game.add(menu_Game_New);
        menu_Game_New.addActionListener(this);

        menu_Game_SetPosition = new JMenuItem("Set-Up Position");
        menu_Game.add(menu_Game_SetPosition);
        menu_Game_SetPosition.addActionListener(this);

        // Insert a separator between New Game and Takeback
        menu_Game.addSeparator();

        menu_Game_Takeback = new JMenuItem("Takeback Move");
        menu_Game.add(menu_Game_Takeback);
        menu_Game_Takeback.addActionListener(this);

        // Init Load Game Menu
        menu_Game_Load = new JMenuItem("Load Game");
        menu_Game.add(menu_Game_Load);
        menu_Game_Load.addActionListener(this);

        // Init Save Game Menu
        menu_Game_Save = new JMenuItem("Save Game");
        menu_Game.add(menu_Game_Save);
        menu_Game_Save.addActionListener(this);

        // Insert a separator between items and Exit
        menu_Game.addSeparator();

        // Init Load Game Menu
        menu_Game_Exit = new JMenuItem("Exit");
        menu_Game.add(menu_Game_Exit);
        menu_Game_Exit.addActionListener(this);

        // Options
        menu_Options = new JMenu("Options");
        menuBar.add(menu_Options);

        menu_Opt_Database = new JMenuItem("Database Settings");
        menu_Options.add(menu_Opt_Database);
        menu_Opt_Database.addActionListener(this);

        menu_Network = new JMenu("Network");
        menuBar.add(menu_Network);
        menu_Network.setEnabled(false);

        menu_Network_Host = new JMenuItem("Host Game");
        menu_Network.add(menu_Network_Host);
        menu_Network_Host.addActionListener(this);

        menu_Network_Connect = new JMenuItem("Connect to Game");
        menu_Network.add(menu_Network_Connect);
        menu_Network_Connect.addActionListener(this);

        // View
        menu_View = new JMenu("View");
        menuBar.add(menu_View);

        menu_View_Flip = new JMenuItem("Flip Board");
        menu_View.add(menu_View_Flip);
        menu_View_Flip.addActionListener(this);

        // Initialize Tabbed Pane, which contains game info
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(420, 0, TAB_WIDTH, TAB_HEIGHT);
        tabbedPane.setDoubleBuffered(true);

        // Set up some buttons and other options for the user to press
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();//0,2,0,0);

        Panel gamePanel = new Panel(gridBag);//new GridLayout(0,1));
        gamePanel.setBackground(new Color(204, 204, 204));
        gamePanel.setBounds(0, 0, TAB_WIDTH, 400);
        JLabel label_Nodes = new JLabel("Nodes");
        JLabel label_NodesSecond = new JLabel("Nodes per second");
        JLabel label_Depth = new JLabel("Depth");
        JLabel label_Score = new JLabel("Score");
        JLabel label_Thinking = new JLabel("Thinking Lines");
        JLabel label_MoveTime = new JLabel("Move Time");

        gc.weighty = 1;

        // Add the node count label
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.weightx = 1.0;
        gc.gridwidth = 1;
        gridBag.setConstraints(label_Nodes, gc);

        gamePanel.add(label_Nodes);

        // Add the node count field
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 1.0;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(field_Nodes, gc);

        gamePanel.add(field_Nodes);

        // Add the nodes per second label
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.gridwidth = 1;
        gc.weightx = 1.0;
        gridBag.setConstraints(label_NodesSecond, gc);

        gamePanel.add(label_NodesSecond);

        // Add the nodes per second field
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 1.0;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(field_NodesSecond, gc);
        gamePanel.add(field_NodesSecond);

        // Add the depth label
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.gridwidth = 1;
        gc.weightx = 1.0;
        gridBag.setConstraints(label_Depth, gc);

        gamePanel.add(label_Depth);

        // Add the depth field
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 1.0;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(field_Depth, gc);
        gamePanel.add(field_Depth);

        // Add the score label
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.VERTICAL;
        gc.gridwidth = 1;
        gc.weightx = 1.0;
        gridBag.setConstraints(label_Score, gc);

        gamePanel.add(label_Score);

        // Add the score field
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 1.0;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(field_Score, gc);
        gamePanel.add(field_Score);

        // Add the thinking lines label
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridwidth = 3;
        gc.weightx = 2;
        gridBag.setConstraints(label_Thinking, gc);
        gamePanel.add(label_Thinking);

        // Add the thinking lines field
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 0.25;
        gc.fill = GridBagConstraints.NONE;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(field_Thinking, gc);
        gamePanel.add(field_Thinking);

        // Add the move time label
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridwidth = 3;
        gc.weightx = 2;
        gridBag.setConstraints(label_MoveTime, gc);
        gamePanel.add(label_MoveTime);

        // Add the move time field
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 0.25;
        gc.fill = GridBagConstraints.NONE;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(field_MoveTime, gc);
        gamePanel.add(field_MoveTime);
        // Add the Visual Thinking checkbox
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(chk_VisualThinking, gc);
        gamePanel.add(chk_VisualThinking);
        chk_VisualThinking.addActionListener(this);
        // Add the Slow Redraws checkbox
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(chk_SlowRedraws, gc);
        gamePanel.add(chk_SlowRedraws);
        chk_SlowRedraws.addActionListener(this);
        // Add the Iterative Deepening checkbox
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(chk_IterativeDeep, gc);
        gamePanel.add(chk_IterativeDeep);
        chk_IterativeDeep.addActionListener(this);
        // Add the Play as White Radio button
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(radio_White, gc);
        gamePanel.add(radio_White);
        radioGroup.add(radio_White);
        radio_White.addActionListener(this);
        // Add the Play as Black Radio button
        gc.anchor = GridBagConstraints.WEST;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(radio_Black, gc);
        gamePanel.add(radio_Black);
        radioGroup.add(radio_Black);
        radio_Black.addActionListener(this);
        // Add difficulty slider LABEL
        JLabel sliderLabel = new JLabel("AI Search Depth");
        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(sliderLabel, gc);
        gamePanel.add(sliderLabel);
        // Add the difficulty slider
        gc.anchor = GridBagConstraints.CENTER;
        gc.weightx = 1;
        gc.fill = GridBagConstraints.BOTH;
        gc.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(difficultySlider, gc);
        difficultySlider.setSnapToTicks(true);
        difficultySlider.setMajorTickSpacing(1);
        difficultySlider.setPaintTicks(true);
        difficultySlider.setPaintTrack(true);
        difficultySlider.setPaintLabels(true);
        difficultySlider.createStandardLabels(20);
        difficultySlider.addChangeListener(this);
        difficultySlider.repaint();
        gamePanel.add(difficultySlider);
        tabbedPane.add("Game", gamePanel);
        moveTable.getTableHeader().setReorderingAllowed(false);
        moveTable.getColumnModel().getColumn(0).setHeaderValue("#");
        moveTable.getColumnModel().getColumn(1).setHeaderValue("White");
        moveTable.getColumnModel().getColumn(2).setHeaderValue("Black");
        moveTable.getColumnModel().getColumn(0).setMaxWidth(20);
        moveTable_scrollPane.setBounds(0, 50, 200, TAB_HEIGHT);
        moveTable_scrollPane.createVerticalScrollBar();
        moveTable_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tabbedPane.add("Move List", moveTable_scrollPane);
        // Set-up and add a graph of who's winning
        graphScroll.setViewportView(graph);
        graphScroll.createHorizontalScrollBar();
        graphScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        graphScroll.setBounds(0, 50, 200, TAB_HEIGHT);
        tabbedPane.add("Graph", graphScroll);
        tabbedPane.setSelectedIndex(2);
        // Add our tabbed pane to the content layout
        con.add(tabbedPane);
        tabbedPane.updateUI();
//        chess = new Chess(this);
        aiCaller = new AICaller(chess);
        aiCaller.start();

//        this.setJMenuBar(menuBar);
        thisMain.setJMenuBar(menuBar);

//        this.pack();
        thisMain.pack();

        // Resize the window to a very precise size that will fit on most displays
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Determine the user name to be displayed in the title bar
        this.setTitle(System.getProperty("user.name") + " vs. Computer");
        this.setVisible(true);

        repaint();
        tabbedPane.repaint();

        Thread mainThread;
        mainThread = new Thread(this);
        mainThread.start();

        /**
         * Redraw the screen at least every 25 ms
         */
        timer.schedule(new TimerTask() {
            int nodesSecond = 0;

            @Override
            public void run() {
                if (!Chess.bThinking || (bSlowRedraws && bVisualThinking)) {
                    bRedraw = true;
                }

                if (Chess.bThinking) {
                    ++moveTime;	// since this function is called every second, just increment the move timer

                    field_NodesSecond.setText("" + (Chess.nodeCount - nodesSecond));
                    nodesSecond = Chess.nodeCount;

                    field_Nodes.setText("" + Chess.nodeCount);
                    field_Depth.setText(Chess.maxDepth + "/" + Chess.reachedDepth);

                    tempString = new String();
                    for (int i = 0; i < Chess.reachedDepth; i++) {
                        tempString += Chess.principalVariation[i].toString() + " ";
                    }

                    field_Thinking.setText(tempString);

                    field_MoveTime.setText(moveTime + " seconds");

                } else {
                    nodesSecond = 0;
                }
            }
        }, 0, 1000);
        NewGame();
    }

    @Override
    public void update(Graphics g) {
        if (offScreen == null || offScreen.getWidth(this) != this.getWidth() || offScreen.getHeight(this) != this.getHeight()) {
            offScreen = null;
            offScreen = this.createImage(BOARD_WIDTH + 2 * HORZ_OFFSET + 10, BOARD_HEIGHT + 2 * VERT_OFFSET + 30);
        }
        Graphics gr = offScreen.getGraphics();
        paint(gr);
        g.drawImage(offScreen, HORZ_OFFSET, VERT_OFFSET, this);
    }

    @Override
    public void paint(Graphics g) {
        drawPosition(g, BOARD_HORZ_OFFSET, BOARD_VERT_OFFSET);
        tabbedPane.repaint();
    }

    static Main thisMain;

    static Color colDarkSquare = new Color(70, 51, 43);
    static Color colLightSquare = new Color(255, 197, 120);
    static Color colDarkGreySquare = new Color(113, 118, 114);
    static Color colLightGreySquare = new Color(190, 198, 204);
    static Color colDarkRedSquare = new Color(107, 3, 3);
    static Color colLightRedSquare = new Color(240, 227, 212);

    static ChessPosition paintPos = Chess.pos;
    static boolean bBlueScreen = false; // is the visual thinking working

    public static void drawPosition(Graphics g, int xOffset, int yOffset) {
        boolean bIsBlack = false;
        int xPos = 0;
        int yPos = 0;
        int imgHover = 0;
        Color darkColor = colDarkSquare;
        Color lightColor = colLightSquare;
        if (bSetPosition) {
            darkColor = colDarkRedSquare;
            lightColor = colLightRedSquare;
        }
        if (Chess.bThinking) {
            if (bVisualThinking) {
                bBlueScreen = true;
                darkColor = colDarkGreySquare;
                lightColor = colLightGreySquare;
                paintPos = Chess.workPos;
            } else {
                paintPos = Chess.pos;
                bBlueScreen = false;
            }
        } else {
            paintPos = Chess.pos;
            bBlueScreen = false;
        }
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                xPos = TILE_WIDTH * x + xOffset;
                yPos = TILE_HEIGHT * y + yOffset;
                g.setColor(bIsBlack ? darkColor : lightColor);
                g.fillRect(xPos, yPos, TILE_WIDTH, TILE_HEIGHT);
                bIsBlack = !bIsBlack;
                int square = bFlipBoard ? (7 - y) * 10 + (7 - x) : y * 10 + x;
                int tileVal = paintPos.board[square]; // Get(x, y)
                if (bBlueScreen) {
                    if (Chess.principalVariation[1].from != 0 && Chess.principalVariation[1].to != 0) {
                        if (Chess.principalVariation[1].from == square) {
                            g.setColor(Color.green);
                            g.drawRect(xPos, yPos, TILE_WIDTH - 1, TILE_HEIGHT - 1);
                        } else if (Chess.principalVariation[1].to == square) {
                            g.setColor(Color.green);
                            g.drawRect(xPos, yPos, TILE_WIDTH - 1, TILE_HEIGHT - 1);
                        }
                    }
                    if (Chess.principalVariation[0].from != 0 && Chess.principalVariation[0].to != 0) {
                        if (Chess.principalVariation[0].from == square) {
                            g.setColor(Color.yellow);
                            g.drawRect(xPos, yPos, TILE_WIDTH - 1, TILE_HEIGHT - 1);
                        } else if (Chess.principalVariation[0].to == square) {
                            g.setColor(Color.yellow);
                            g.drawRect(xPos, yPos, TILE_WIDTH - 1, TILE_HEIGHT - 1);
                        }
                    }
                } else if (lastMove.from != 0 && lastMove.to != 0) {
                    if (lastMove.from == square) {
                        g.setColor(Color.blue);
                        g.drawRect(xPos, yPos, TILE_WIDTH - 1, TILE_HEIGHT - 1);
                    } else if (lastMove.to == square) {
                        g.setColor(Color.blue);
                        g.drawRect(xPos, yPos, TILE_WIDTH - 1, TILE_HEIGHT - 1);
                    }
                }
                if (tileVal != ChessPosition.BLANK) {
                    int imgVal = tileVal;
                    if (imgVal < 0) {
                        imgVal = -imgVal + 6;
                    }
                    --imgVal;
                    if (square + 1 == hoverPiece) {
                        imgHover = imgVal;
                    } else {
                        g.drawImage(images[imgVal], xPos, yPos, thisMain);
                    }
                }
            }
            bIsBlack = !bIsBlack;
        }
        if (hoverPiece > 0) {
            g.drawImage(images[imgHover],
                    mouse_x - TILE_WIDTH / 2,
                    mouse_y - TILE_HEIGHT / 2,
                    thisMain);
        }
        g.setColor(chess.bWhoseTurn ? Color.white : Color.black);
        g.fillRect(BOARD_WIDTH, yOffset, 10, BOARD_HEIGHT);
    }

//    public void ShowHelpDialog() {
//        JFrame frame = new JFrame("Chessmate HTML Help");
//        frame.setSize(620, 440);
//        Container con = frame.getContentPane();
//        con.setLayout(new BorderLayout());
//        JPanel panel = new JPanel(new BorderLayout());
//        System.out.println(System.getProperty("user.dir"));
//        frame.setSize(700, 500);
//        frame.show();
//
//    }
    int paintCount = 0;

    @Override
    public void run() {
        while (!bQuit) {
            if (Chess.bThinking && bVisualThinking && !bSlowRedraws) {
                ++paintCount;
                if (paintCount >= 4) // every 100 ms
                {
                    paintCount = 0;
                    repaint();
                }
            } else if (bRedraw) {
                repaint();
                bRedraw = false;
            }
            try {
                Thread.sleep(25);
            } catch (java.lang.InterruptedException e) {
                System.err.println("Error in main update thread.");
            }
        }
    }

//    public ChessPosition pos;
    public static void main(String[] args) {
//        JFrame fr = new Main();
        Main frame = new Main();
    }
}

//    AICaller aiCaller;
