import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
    
    private JButton[][] board;
    private JButton newGameBtn;
    private JLabel statusLabel;
    private int turn;
    private int moves;

    public TicTacToe() {
        setTitle("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        board = new JButton[3][3];
        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new JButton("");
                board[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                board[i][j].addActionListener(this);
                boardPanel.add(board[i][j]);
            }
        }

        newGameBtn = new JButton("New Game");
        newGameBtn.addActionListener(this);

        statusLabel = new JLabel("X's turn");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JPanel controlPanel = new JPanel(new GridLayout(1, 3));
        controlPanel.add(statusLabel);
        controlPanel.add(newGameBtn);

        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        turn = 1;
        moves = 0;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameBtn) {
            resetGame();
        } else {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("")) {
                moves++;
                if (turn == 1) {
                    button.setText("X");
                    statusLabel.setText("O's turn");
                    turn = 2;
                } else {
                    button.setText("O");
                    statusLabel.setText("X's turn");
                    turn = 1;
                }
                checkGame();
            }
        }
    }

    private void checkGame() {
        String winner = "";
        // check rows
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].getText().equals("") && board[i][0].getText().equals(board[i][1].getText()) && board[i][0].getText().equals(board[i][2].getText())) {
                winner = board[i][0].getText();
                break;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (!board[0][i].getText().equals("") && board[0][i].getText().equals(board[1][i].getText()) && board[0][i].getText().equals(board[2][i].getText())) {
                winner = board[0][i].getText();
                break;
            }
        }
        // check diagonals
        if (!board[0][0].getText().equals("") && board[0][0].getText().equals(board[1][1].getText()) && board[0][0].getText().equals(board[2][2].getText())) {
            winner = board[0][0].getText();
        }
        if (!board[0][2].getText().equals("") && board[0][2].getText().equals(board[1][1].getText()) && board[0][2].getText().equals(board[2][0].getText())) {
            winner = board[0][2].getText();
        }
            // check for a winner
    // check for a winner
    if (!winner.equals("")) {
        statusLabel.setText(winner + " wins!");
        disableBoard();
    } else if (moves == 9) { // check for a tie
        statusLabel.setText("Tie game!");
        disableBoard();
    }
}

private void disableBoard() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j].setEnabled(false);
        }
    }
}

private void resetGame() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j].setText("");
            board[i][j].setEnabled(true);
        }
    }
    turn = 1;
    moves = 0;
    statusLabel.setText("X's turn");
}

public static void main(String[] args) {
    TicTacToe game = new TicTacToe();
    game.setVisible(true);
}
}