import java.util.Scanner;
class Main {
    static char[][] board = {
        {'-','-','-','-','-','-','-','-'},
        {'|', ' ', '|', ' ', '|', ' ', '|'},
        {'-','-','-','-','-','-','-','-'},
        {'|', ' ', '|', ' ', '|', ' ', '|'},
        {'-','-','-','-','-','-','-','-'},
        {'|', ' ', '|', ' ', '|', ' ', '|'},
        {'-','-','-','-','-','-','-','-'},
    };
    static boolean gameEnd = false;
    
    public static void main(String[] g) { 
        String playerX = "Player X";
        String playerO = "Player O";
        welcomeMessage();
        while(!gameEnd) {
            System.out.println("___________________________" + playerX + " Turn_____________________________");
            play(playerX, 'X');

            if(gameEnd) break;

            System.out.println("___________________________" + playerO + " Turn_____________________________");
            play(playerO, 'O');
        }
    }
    
    private static void welcomeMessage() {
        System.out.println("_____________________________________________________________________\n");
        String a, b, c, d, e, f, g;
        //Welcome To The Tic Toc Toe

                         a="@@@@@@@                @@@@@@@                  @@@@@@@               \n";
                         b="   @    @  @@@@           @      @@    @@@@        @     @@@@  @@@@@@ \n";
                         c="   @    @ @    @          @     @  @  @    @       @    @    @ @      \n";
                         d="   @    @ @               @    @    @ @            @    @    @ @@@@@  \n";
                         e="   @    @ @               @    @@@@@@ @            @    @    @ @      \n";
                         f="   @    @ @    @          @    @    @ @    @       @    @    @ @      \n";
                         g="   @    @  @@@@           @    @    @  @@@@        @     @@@@  @@@@@@ \n";
                         
        System.out.println(a+b+c+d+e+f+g);
                                              
        System.out.println("By: Deepak Gautam");
        System.out.println("Email: gautamxdeepak@gmail.com");
        System.out.println("YouTube: https://www.youtube.com/DeepakGautamX");
        System.out.println("Website: https://deepak5j.bitbucket.io/");   
        System.out.println("_____________________________________________________________________");
        System.out.println("\n\n");                          
    }

    private static void play(String player, char p) {
        Scanner console = new Scanner(System.in);
        boolean move = false;
        String tmp;
        System.out.print(player + ", please enter a ROW number (0, 1, 2): ");
        int rowInp;
        while(!move) {
            while (true) {
                tmp = console.nextLine();
                if(tmp.length() > 1) {
                    System.out.print("Please, enter correct option. Chose among (0, 1, 2) only!!: ");
                }
                else if(tmp.equals("0") || tmp.equals("1") || tmp.equals("2")) {
                    rowInp = Integer.parseInt(tmp);
                    break;
                }
                else {
                    System.out.print("Please, enter correct option. Chose among (0, 1, 2) only!!: ");
                }
            }
            System.out.print(player + ", please enter a COLUMN number (0, 1, 2): ");
            int columnInp;
            while (true) {
                tmp = console.nextLine();
                if(tmp.length() > 1) {
                    System.out.print("Please, enter correct option. Chose among (0, 1, 2) only!!: ");
                }
                else if(tmp.equals("0") || tmp.equals("1") || tmp.equals("2")) {
                    columnInp = Integer.parseInt(tmp);
                    break;
                }
                else {
                    System.out.print("Please, enter correct option. Chose among (0, 1, 2) only!!: ");
                }
            }
            move = update(rowInp, columnInp, p);  
            if(!move) {
                System.out.print("Wrong move!! " + player + ". Block is filled!! Press Enter key and continue.");
            }       
        }
        display();
        gameWinnerCheck(player, p);
    }

    private static void gameWinnerCheck(String player, char p) {
        //row won
        if(board[1][1] == p && board[1][3] == p && board[1][5] == p) gameEnd = true;
        if(board[3][1] == p && board[3][3] == p && board[3][5] == p) gameEnd = true;
        if(board[5][1] == p && board[5][3] == p && board[5][5] == p) gameEnd = true;
        
        //column won
        if(board[1][1] == p && board[3][1] == p && board[5][1] == p) gameEnd = true;
        if(board[1][3] == p && board[3][3] == p && board[5][3] == p) gameEnd = true;
        if(board[1][5] == p && board[3][5] == p && board[5][5] == p) gameEnd = true;
        
        //diagonal won
        if(board[1][1] == p && board[3][3] == p && board[5][5] == p) gameEnd = true;
        
        //reverse diagonal won
        if(board[1][5] == p && board[3][3] == p && board[5][1] == p) gameEnd = true;
        
        boolean drawCheck = false;
        if(board[1][1] != ' ' && board[1][3] != ' ' && board[1][5] != ' ' 
        && board[3][1] != ' ' && board[3][3] != ' ' && board[3][5] != ' '
        && board[5][1] != ' ' && board[5][3] != ' ' && board[5][5] != ' '
        ) drawCheck = true;   
        
        if(gameEnd) {
            System.out.println();
            System.out.println("_____________________________________________________________________");
            System.out.println("                          "+player+" Win!!!");
            System.out.println("_____________________________________________________________________");
            System.out.println();
            drawCheck = false;
        }

        if(drawCheck) {
            System.out.println();
            System.out.println("_____________________________________________________________________");
            System.out.println("                    Draw!! Game End, Play Again.");
            System.out.println("_____________________________________________________________________");
            System.out.println();
            gameEnd = true;
        }                  
    }

    private static boolean update(int x, int y, char p) {
        if(!gameEnd) {
            if(board[2*x+1][2*y+1] != ' ') {
                return false;                
            }
            board[2*x+1][2*y+1] = p;                       
        }
        return true;
    }

    private static void display() {
        for(int i=0; i<7; i++) {
            for(int j=0; j<7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}