import java.util.*;

/**
 * Node class to answer problem 1 -  huffman tree
 */
class HuffmanNode{
    char c;
    int freq;
    String path;

    public HuffmanNode(char c, int freq, String path){
        this.c = c;
        this.freq = freq;
        this.path = path;
    }
}

/**
 * Node class for B-tree
 */
class BNode{
    List data;
    List<BNode> children;

    public BNode(List data){
        this.data = data;
        this.children = new ArrayList<BNode>();
    }
    public void setChildren(List<BNode> children){
        this.children = children;
    }

    public void addChildren(BNode node){
        this.children.add(node);
    }
}




/**
 * Java file that stores answers to problem 1(huffman encoding) and problem 2(B-tree)
 */
public class Worksheet {


    /**
     * Answer to q1(a)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1aEncodeChar(){
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        nodeList.add(new HuffmanNode('1', 1, "100000"));
        nodeList.add(new HuffmanNode('s', 1, "100001"));
        nodeList.add(new HuffmanNode('4', 1, "100010"));
        nodeList.add(new HuffmanNode('d', 1, "100011"));
        nodeList.add(new HuffmanNode('3', 1, "10010"));
        nodeList.add(new HuffmanNode('c', 1, "10011"));
        nodeList.add(new HuffmanNode('5', 1, "11010"));
        nodeList.add(new HuffmanNode('6', 1, "11011"));
        nodeList.add(new HuffmanNode('2', 2, "1100"));
        nodeList.add(new HuffmanNode('w', 6, "101"));
        nodeList.add(new HuffmanNode('\n', 5, "111"));
        nodeList.add(new HuffmanNode('0', 7, "00"));
        nodeList.add(new HuffmanNode('h', 6, "01"));
        return nodeList;
    }

    /**
     * Answer to q1(b)
     * @return arrayList consisting HuffmanNodes, where each node stores info about an encoded character
     */
    public static ArrayList<HuffmanNode> q1bEncodeChar(){
        ArrayList<HuffmanNode> nodeList = new ArrayList<HuffmanNode>();
        nodeList.add(new HuffmanNode('c', 1, "00100"));
        nodeList.add(new HuffmanNode('o', 1, "00101"));
        nodeList.add(new HuffmanNode('l', 1, "0011"));
        nodeList.add(new HuffmanNode('!', 1, "1000"));
        nodeList.add(new HuffmanNode('r', 1, "1001"));
        nodeList.add(new HuffmanNode('h', 1, "1010"));
        nodeList.add(new HuffmanNode('i', 1, "1011"));
        nodeList.add(new HuffmanNode('T', 1, "1100"));
        nodeList.add(new HuffmanNode('u', 1, "1101"));
        nodeList.add(new HuffmanNode(' ', 3, "000"));
        nodeList.add(new HuffmanNode('e', 3, "010"));
        nodeList.add(new HuffmanNode('s', 3, "011"));
        nodeList.add(new HuffmanNode('m', 2, "111"));
        return nodeList;
    }

    /**
     * Answer to 2(a)
     * @return a list of BNodes
     */
    public static ArrayList<BNode> q2EncodeTree(){
        ArrayList<BNode> nodeList = new ArrayList<BNode>();
        //example of adding nodes to nodeList : nodeList.add(new BNode(Arrays.asList(17,24)));
        return nodeList;

    }

    public static void main(String[] args) {
        ArrayList<BNode> nodes = q2EncodeTree();
        System.out.println("number of nodes  = "+nodes.size());
        for(int i = nodes.size()-1;i>=0;i--){
            List<BNode> children = nodes.get(i).children;
            String output = "";
            output+="current data = "+nodes.get(i).data+"\n";
            output+="children = ";
            if(children.size()==0){
                output+="None";
            }
            for(int j=0;j<children.size();j++){
                output+=children.get(j).data;
            }
            System.out.println(output);
            System.out.println("____________________");
        }
    }
}
