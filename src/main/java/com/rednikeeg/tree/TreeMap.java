package com.rednikeeg.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class TreeMap {
    private static class Node {
        String key;
        String value;
        Node left;
        Node right;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " : " + value;
        }
    }

    private Node root;

    public TreeMap() {

    }

    public boolean insert(String key, String value) {
        if (root == null) {
            root = new Node(key, value);

            return true;
        } else {
            return insert(root, key, value);
        }
    }

    private boolean insert(Node node, String key, String value) {
        if (key.compareTo(node.key) < 0) {
            if (node.left == null) {
                node.left = new Node(key, value);
                node.left.key = key;
                node.left.value = value;
                return true;
            } else {
                return insert(node.left, key, value);
            }
        } else if (key.compareTo(node.key) > 0) {
            if (node.right == null) {
                node.right = new Node(key, value);
                node.right.key = key;
                node.right.value = value;
                return true;
            } else {
                return insert(node.right, key, value);
            }
        } else {
            return false;
        }
    }

    public String get(String key) {
        if (root == null) {
            return null;
        } else {
            return get(root, key);
        }
    }

    private String get(Node node, String key) {
        if (key.compareTo(node.key) < 0) {
            if (node.left == null) {
                return null;
            } else {
                return get(node.left, key);
            }
        } else if (key.compareTo(node.key) > 0) {
            if (node.right == null) {
                return null;
            } else {
                return get(node.right, key);
            }
        } else {
            return node.value;
        }
    }

    public void delete(String key) {
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();

        BiConsumer<String, String> addToList = (s1, s2) -> {
            if(!s1.equals(key)) {
                keys.add(s1);
                values.add(s2);
            }
        };

        getInOrder(addToList);

        root = null;

        for (int i = 0; i < keys.size(); i++) {
            insert(keys.get(i), values.get(i));
        }
    }

    public void getInOrder(BiConsumer<String, String> consumer) {
        getInOrder(root, consumer);
    }

    public void getInOrder(Node node, BiConsumer<String, String> consumer) {
        if (node != null) {
            getInOrder(node.left, consumer);
            consumer.accept(node.key, node.value);
            getInOrder(node.right, consumer);
        }
    }
}
