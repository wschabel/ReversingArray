import java.util.*;

public class Main {
   public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();
      Queue<Integer> queue = new LinkedList<>();

      Scanner scanner = new Scanner(System.in);

      int count = 0;

      while (count <= 0) {
         System.out.print("How many values would you like to enter? ");
         try {
            count = scanner.nextInt();

            if (count <= 0) {
               System.out.println("Number of values must be greater than 0.");
            }
         } catch (InputMismatchException e) {
            System.out.println("You must enter a valid integer.");
            scanner.nextLine();
         }
      }

      int[] array = new int[count];

      for (int i = 0; i < count; i++) {
         int number;
         while(true) {
            System.out.print("Choose a number. ");
            try {
               number = scanner.nextInt();
               array[i] = number;
               stack.push(number);
               queue.offer(number);
               break;
            } catch (InputMismatchException e) {
               System.out.println("You must enter a valid integer.");
               scanner.nextLine();
            }
         }
      }

      System.out.println("\nOriginal Collections:");

      System.out.print("Array: ");
      displayArray(array);

      System.out.print("\nStack: ");
      displayStack(stack);

      System.out.print("\nQueue: ");
      displayQueue(queue);

      reverseArray(array);
      stack = reverseStack(stack);
      reverseQueue(queue);

      System.out.println("\n\nReversed Collections:");

      System.out.print("Array: ");
      displayArray(array);

      System.out.print("\nStack: ");
      displayStack(stack);

      System.out.print("\nQueue: ");
      displayQueue(queue);
   }

   public static void displayArray(int[] array) {
      for (int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " ");
      }
   }

   public static void displayStack(Stack<Integer> stack) {
      for (int i = 0; i < stack.size(); i++) {
         System.out.print(stack.elementAt(i) + " ");
      }
   }

   public static void displayQueue(Queue<Integer> queue) {
      for (int number : queue) {
         System.out.print(number + " ");
      }
   }

   public static void reverseArray(int[] array) {
      int left = 0;
      int right = array.length - 1;

      while (left < right) {
         int temp = array[left];
         array[left] = array[right];
         array[right] = temp;

         left += 1;
         right -= 1;
      }
   }

   public static Stack<Integer> reverseStack(Stack<Integer> stack)
   {
      Stack<Integer> reversed = new Stack<>();

      while (!stack.isEmpty())
      {
         reversed.push(stack.pop());
      }

      return reversed;
   }

   public static void reverseQueue(Queue<Integer> queue)
   {
      Stack<Integer> temp = new Stack<>();

      while (!queue.isEmpty())
      {
         temp.push(queue.poll());
      }

      while (!temp.isEmpty())
      {
         queue.offer(temp.pop());
      }
   }
}