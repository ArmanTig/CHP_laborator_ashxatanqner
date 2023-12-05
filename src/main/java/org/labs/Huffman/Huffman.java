package org.example.Huffman;


import java.util.PriorityQueue;
import java.util.HashMap;



public class Huffman {

    public static HuffmanNode buildHuffmanTree(HashMap<Character, Integer> frequencyMap) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        // Create a leaf node for each unique character and add it to the priority queue
        for (char c : frequencyMap.keySet()) {
            priorityQueue.offer(new HuffmanNode(c, frequencyMap.get(c)));
        }

        // Build the Huffman tree
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode internalNode = new HuffmanNode('\0', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;

            priorityQueue.offer(internalNode);
        }

        return priorityQueue.poll(); // The root of the Huffman tree
    }

    public static void generateHuffmanCodes(HuffmanNode root, String code, HashMap<Character, String> huffmanCodes) {
        if (root == null) {
            return;
        }

        // If the node is a leaf, add its code to the map
        if (root.data != '\0') {
            huffmanCodes.put(root.data, code);
        }

        // Traverse left and append '0' to the code
        generateHuffmanCodes(root.left, code + "0", huffmanCodes);

        // Traverse right and append '1' to the code
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    public static String encode(String input, HashMap<Character, String> huffmanCodes) {
        StringBuilder encoded = new StringBuilder();

        for (char c : input.toCharArray()) {
            encoded.append(huffmanCodes.get(c));
        }

        return encoded.toString();
    }

    public static String decode(HuffmanNode root, String encoded) {
        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encoded.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else if (bit == '1') {
                current = current.right;
            }

            if (current.data != '\0') {
                decoded.append(current.data);
                current = root;
            }
        }

        return decoded.toString();
    }


}
