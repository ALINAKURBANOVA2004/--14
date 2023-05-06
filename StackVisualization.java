import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StackVisualization extends JPanel {
    private LinkedList stack;

    public StackVisualization(LinkedList stack) {
        this.stack = stack;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = 250;int x=550;
        for (Node current = stack.getHead(); current != null; current = current.getNext()) {
            g.setColor(Color.ORANGE);
            g.drawRect(x,y, 100,80);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(current.getData()),x+40, y+40);
            y += 80;
        }
    }

    public static void main(String[] args) {
        LinkedList stack = new LinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();

        JFrame frame = new JFrame("Stack Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new StackVisualization(stack));
        frame.setVisible(true);
    }
}

class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void push(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public Node pop() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.getNext();
        temp.setNext(null);
        size--;
        return temp;
    }

    public Node getHead() {
        return head;
    }

    public int size() {
        return size;
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}