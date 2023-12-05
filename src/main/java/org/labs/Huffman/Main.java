package org.example.Huffman;

import org.example.Huffman.Node;

import java.util.HashMap;

import static org.example.Huffman.Huffman.*;

public class Main {
    public static void main(String[] args) {
        String inputMessage = "hello world";

        // Calculate character frequencies
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputMessage.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Build the Huffman tree
        Node huffmanTree = buildHuffmanTree(frequencyMap);

        // Generate Huffman codes
        HashMap<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(huffmanTree, "", huffmanCodes);

        // Encode the message
        String encodedMessage = encode(inputMessage, huffmanCodes);
        System.out.println("Encoded Message: " + encodedMessage);

        // Decode the message
        String decodedMessage = decode(huffmanTree, encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }
}
