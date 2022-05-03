import model.Data;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<Data> items = new ArrayList<>();
        items.add(new Data(1,"Соки",0));
        items.add(new Data(2,"Манго",1));
        items.add(new Data(3,"Виноградный",1));
        items.add(new Data(4,"Яблочный",1));
        items.add(new Data(5,"Газировка",0));
        items.add(new Data(6,"Кола",5));
        items.add(new Data(7,"Кола 0.5л",6));
        items.add(new Data(8,"Кола 1.5л",6));
        items.add(new Data(9,"Минералка",5));
        items.add(new Data(10,"Лимонад",5));


        for (Data data : items) {
            System.out.println(data.toString());

        }

        DataNode tree = DataNode.makeTree(items, new TreeNode.TypeAdapter<Data, DataNode>() {
            @Override
            public DataNode newInstance() {
                return new DataNode();
            }

            @Override
            public boolean isChildOf(Data parentData, Data childrenData) {
                return parentData.getId() == childrenData.getParentId();
            }

            @Override
            public boolean isTopLevelItem(Data data) {
                return data.getParentId() == 0;
            }
        });

        System.out.println(tree);

        if(tree.children.size() != 0){

        }

     }

    static class DataNode extends TreeNode<Data, DataNode> {

        @Override
        public String toString() {
            return data.getName();
        }
    }
}
