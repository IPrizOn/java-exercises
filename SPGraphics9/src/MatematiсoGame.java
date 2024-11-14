import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class MatematicoGame {
    private JFrame gameFrame;
    private JTextField[][] boardCells;
    private JLabel[] rowScoreLabels;
    private JLabel[] colScoreLabels;
    private JLabel nextNumberLabel;
    private int[] rowScores;
    private int[] colScores;
    private int[] cardDeck;
    private int cardIndex;
    private int currentValue;
    private boolean playerTurn;

    public MatematicoGame() {
        gameFrame = new JFrame("Математико");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setLayout(new BorderLayout());

        JPanel boardPanel = new JPanel(new GridLayout(5, 5));
        boardCells = new JTextField[5][5];
        rowScores = new int[5];
        colScores = new int[5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boardCells[i][j] = new JTextField();
                boardCells[i][j].setHorizontalAlignment(JTextField.CENTER);
                boardCells[i][j].setEditable(false);
                int finalI = i;
                int finalJ = j;
                boardCells[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (playerTurn) {
                            placeValue(finalI, finalJ);
                        }
                    }
                });
                boardPanel.add(boardCells[i][j]);
            }
        }

        JPanel scorePanel = new JPanel(new GridLayout(6, 1));
        rowScoreLabels = new JLabel[5];
        colScoreLabels = new JLabel[5];
        nextNumberLabel = new JLabel("Следующее число: ", SwingConstants.CENTER);

        scorePanel.add(nextNumberLabel);
        for (int i = 0; i < 5; i++) {
            rowScoreLabels[i] = new JLabel("(0)", SwingConstants.CENTER);
            scorePanel.add(rowScoreLabels[i]);
        }
        for (int i = 0; i < 5; i++) {
            colScoreLabels[i] = new JLabel("(0)", SwingConstants.CENTER);
            scorePanel.add(colScoreLabels[i]);
        }

        gameFrame.add(boardPanel, BorderLayout.CENTER);
        gameFrame.add(scorePanel, BorderLayout.EAST);

        initializeDeck();
        drawNextCard();

        gameFrame.setSize(600, 350);
        gameFrame.setVisible(true);
    }

    private void initializeDeck() {
        cardDeck = new int[52];
        int index = 0;
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cardDeck[index++] = i;
            }
        }
        shuffleDeck();
        cardIndex = 0;
        playerTurn = true; 
    }

    private void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < cardDeck.length; i++) {
            int randomIndex = random.nextInt(cardDeck.length);
            int temp = cardDeck[i];
            cardDeck[i] = cardDeck[randomIndex];
            cardDeck[randomIndex] = temp;
        }
    }

    private void drawNextCard() {
        if (cardIndex < cardDeck.length) {
            currentValue = cardDeck[cardIndex++];
            nextNumberLabel.setText("Следующее число: " + currentValue);
            toggleBoardCells(playerTurn);
        } else {
            JOptionPane.showMessageDialog(gameFrame, "Все ячейки заполнены.");
            calculateFinalScores();
        }
    }

    private void drawNextComputerCard() {
        if (cardIndex < cardDeck.length) {
            currentValue = cardDeck[cardIndex++];
        } else {
            JOptionPane.showMessageDialog(gameFrame, "Все ячейки заполнены.");
            calculateFinalScores(); 
        }
    }

    private void placeValue(int row, int col) {
        if (boardCells[row][col].getText().isEmpty()) {
            boardCells[row][col].setText(String.valueOf(currentValue));
            rowScores[row] += currentValue;
            colScores[col] += currentValue;
            rowScoreLabels[row].setText("(" + rowScores[row] + ")");
            colScoreLabels[col].setText("(" + colScores[col] + ")");
            toggleBoardCells(false); 
            if (isBoardFull()) {
                calculateFinalScores(); 
            } else {
                switchTurns(); 
            }
        } else {
            JOptionPane.showMessageDialog(gameFrame, "Эта ячейка уже занята.");
        }
    }

    private void switchTurns() {
        playerTurn = !playerTurn;
        if (!playerTurn) {
            System.out.println("Ход компьютера...");
            computerAction(); 
        } else {
            drawNextCard(); 
        }
    }

    private void computerAction() {
        drawNextComputerCard(); 
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(5);
            col = random.nextInt(5);
        } while (!boardCells[row][col].getText().isEmpty());

        placeValue(row, col);

        if (!isBoardFull()) {
            drawNextCard(); 
        } else {
            calculateFinalScores(); 
        }
    }

    private void toggleBoardCells(boolean enable) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boardCells[i][j].setEditable(enable);
            }
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (boardCells[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void calculateFinalScores() {
        int totalScore = 0;

        for (int i = 0; i < 5; i++) {
            totalScore += calculateLineScore(boardCells[i], false);
        }

        for (int j = 0; j < 5; j++) {
            JTextField[] column = new JTextField[5];
            for (int i = 0; i < 5; i++) {
                column[i] = boardCells[i][j];
            }
            totalScore += calculateLineScore(column, false);
        }

        JTextField[] diagonal1 = new JTextField[5];
        JTextField[] diagonal2 = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            diagonal1[i] = boardCells[i][i];
            diagonal2[i] = boardCells[i][4 - i];
        }
        totalScore += calculateLineScore(diagonal1, true);
        totalScore += calculateLineScore(diagonal2, true);

        JOptionPane.showMessageDialog(gameFrame, "Финальный счёт: " + totalScore);
    }

    private int calculateLineScore(JTextField[] line, boolean isDiagonal) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (JTextField cell : line) {
            int num = Integer.parseInt(cell.getText());
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int score = 0;

        for (int freq : frequencyMap.values()) {
            switch (freq) {
                case 2:
                    score += isDiagonal ? 20 : 10;
                    break;
                case 3:
                    score += isDiagonal ? 50 : 40;
                    break;
                case 4:
                    score += isDiagonal ? 170 : 160;
                    break;
            }
        }

        if (frequencyMap.containsKey(1) && frequencyMap.containsKey(13) &&
                frequencyMap.containsKey(12) && frequencyMap.containsKey(11) &&
                frequencyMap.containsKey(10)) {
            score += isDiagonal ? 160 : 150;
        }

        return score;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MatematicoGame::new);
    }
}