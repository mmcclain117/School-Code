package Mine;

/**
 *
 * @author Master Ward
 */
public class AICaller extends Thread {

    Chess chess;
    boolean bStart = false;

    public void go() {
        bStart = true;
    }

    public void cancel() {
        bStart = false;
    }

    public void exit() {
        bRunning = false;
    }

    private static boolean bRunning = false;

    public AICaller(Chess chess) {
        this.chess = chess;
    }

    @Override
    public void run() {
        if (bRunning) {
            return;
        }
        bRunning = true;
//            while (!Chess.main.bQuit && bRunning) {
        while (true) {
            if (bStart) {
                bStart = false;
                Chess.bThinking = true;
                Chess.main.difficultySlider.setEnabled(false);
                Chess.main.chk_IterativeDeep.setEnabled(false);
                Chess.main.butt_SetupBoard.setEnabled(false);
                Chess.main.menu_Game_SetPosition.setEnabled(false);
                ChessPosition n = chess.playGame(Chess.pos, Chess.PROGRAM);
                if (Chess.bThinking) {
                    Chess.bThinking = false; // consider removing the bRunning?
                    Chess.pos = n;
                }
                Chess.main.difficultySlider.setEnabled(true);
                Chess.main.chk_IterativeDeep.setEnabled(true);
                Chess.main.butt_SetupBoard.setEnabled(true);
                Chess.main.menu_Game_SetPosition.setEnabled(true);
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.out.println("AICaller Thread Sleep Error");
            }
        }
//        bRunning = false;
    }
}
