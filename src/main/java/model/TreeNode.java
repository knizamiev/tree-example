package model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T, N extends TreeNode<T, N>> {

    public N parent;
    public ArrayList<N> children;
    public T data;

    public TreeNode() {
    }


    public TreeNode(N parent, ArrayList<N> children, T data) {
        this.parent = parent;
        this.children = children;
        this.data = data;
    }

    public interface TypeAdapter<T, N> {
        N newInstance();
        boolean isChildOf(T parentData, T childrenData);
        boolean isTopLevelItem(T data);
    }

    public static <T, N extends  TreeNode<T, N>> N makeTree(List<T> datas, TypeAdapter<T, N> typeAdapter){
        N root = typeAdapter.newInstance();
        root.children = new ArrayList<>();
        ArrayList<T> result = new ArrayList<>();
        for(T item: datas) {
            if (typeAdapter.isTopLevelItem(item)) {
                result.add(item);
            }
        }

        for (T top: result) {
            root.children.add(extractNode(top, root, datas, typeAdapter));
        }
        return root;
    }

    protected static <T, N extends TreeNode<T, N>> N extractNode(T data, N parent, List<T> datas, TypeAdapter<T, N> typeAdapter){
        N node = typeAdapter.newInstance();
        node.data = data;
        node.parent = parent;

        ArrayList<T> directChildren = new ArrayList<>();
        for(T item: datas) {
            if (typeAdapter.isChildOf(data, item)) {
                directChildren.add(item);
            }
        }
        if(!directChildren.isEmpty()){
            node.children = new ArrayList<>();
            for (T child : directChildren){
                node.children.add(extractNode(child, node, datas, typeAdapter));
            }
        }
        return node;
    }

}
