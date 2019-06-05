using System;
using TicTacLibrary;
using System.Threading;


namespace TIC_TAC_TOE {

    class Program {

        static Board board;
        static ReadingKeys read;

        static void Main(string[] args) {

            int player = 1;
            int choice = 0;
            int flag = 0;
            read = new ReadingKeys();
            board = new Board();

            do {
                Console.Clear();
                Console.WriteLine("Player1:X and Player2:O");
                Console.WriteLine("\n");

                if (player % 2 == 0) Console.WriteLine("Player 2 Chance\n");
                
                else Console.WriteLine("Player 1 Chance\n");           

                board.GetBoard();

                ConsoleKeyInfo key = Console.ReadKey();
                choice = read.ReadKeys(key.Key);  

            
                if (board.Arr[choice] != 'X' && board.Arr[choice] != 'O') {
                    if (player % 2 == 0) {  
                        board.Arr[choice] = 'O';
                        player++;
                    }
                    else {
                        board.Arr[choice] = 'X';
                        player++;
                    }
                }
                else 
                    Console.WriteLine("Sorry the row {0} is already marked with {1}\n", choice, board.Arr[choice]);
                 
                flag = board.CheckWin();  
                
            } while (flag != 1 && flag != -1);  

            Console.Clear(); 
            board.GetBoard();

            if (flag == 1) Console.WriteLine("Player {0} has won", (player % 2) + 1);

            else Console.WriteLine("Draw");
            
            Console.ReadLine();
        }
    }
}

