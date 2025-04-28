

/* 
 *  Name: Yohannes Ayele
 *  Date: 04/28/25
 *  Assignment: MS: Ayele_M8_ThreeThreads
 *  Purpose of the code: Display Three Threads Output
 *  Gethub: https://github.com/yojohub/csd-420.git
 */

 import javax.swing.*;
 import java.awt.*;
 import java.util.Random;
 
 public class Ayele_M8_ThreeThreads
 extends JFrame {
     private JTextArea lettersOutputArea;
     private JTextArea numbersOutputArea;
     private JTextArea symbolsOutputArea;
 
     public Ayele_M8_ThreeThreads
() {
         setTitle("Display Three Threads Output"); // Set the title of the window
         setSize(900, 700); // Set the size of the window (900x700)
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit the program when the window is closed
 
         setLayout(new GridLayout(3, 1)); // Arrange the components in 3 rows
 
         // Set up the JTextArea components
         lettersOutputArea = new JTextArea();
         numbersOutputArea = new JTextArea();
         symbolsOutputArea = new JTextArea();
 
         // Set line wrap to make the text look good.
         lettersOutputArea.setLineWrap(true);
         numbersOutputArea.setLineWrap(true);
         symbolsOutputArea.setLineWrap(true);
 
         // Set the initial text labels
         lettersOutputArea.setText("Letters Output:\n");
         numbersOutputArea.setText("Numbers Output:\n");
         symbolsOutputArea.setText("Symbols Output:\n");
 
         //Include the scrollable JTextArea components in the JFrame.
         add(new JScrollPane(lettersOutputArea));
         add(new JScrollPane(numbersOutputArea));
         add(new JScrollPane(symbolsOutputArea));
     }
        // This will create a new thread for each type of output
     public void startThreads() {
         Thread lettersThread = new Thread(() -> generateCharacters(lettersOutputArea, "letters"));
         Thread numbersThread = new Thread(() -> generateCharacters(numbersOutputArea, "numbers"));
         Thread symbolsThread = new Thread(() -> generateCharacters(symbolsOutputArea, "symbols"));
 
         lettersThread.start();
         numbersThread.start();
         symbolsThread.start();
     }
 
     // Generating random characters (letters, numbers, and symbols) 
     private void generateCharacters(JTextArea targetArea, String type) {
         Random random = new Random();
         int count = 0;
 
         while (count < 10000) {
             char ch;
             switch (type) {
                 case "letters":
                     ch = (char) (random.nextInt(26) + 'a');
                     break;
                 case "numbers":
                     ch = (char) (random.nextInt(10) + '0');
                     break;
                 case "symbols":
                     char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
                     ch = symbols[random.nextInt(symbols.length)];
                     break;
                 default:
                     ch = '?';
             }
 
             char finalCh = ch;
             SwingUtilities.invokeLater(() -> targetArea.append(String.valueOf(finalCh)));
 
             count++;
             try {
                 Thread.sleep(1); // Small delay to keep UI smooth
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }
 
     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
             Ayele_M8_ThreeThreads
 frame = new Ayele_M8_ThreeThreads
();
             frame.setVisible(true);
             frame.startThreads();
         });
     }
 }
 