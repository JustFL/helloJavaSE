package jdbc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDao {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        BaseDao b = new BaseDao();
        String sql = "select * from student;";
        ArrayList<Student> select = b.select(sql, Student.class);
//		String sql = "update student set age = ? where id = ?";
//		System.out.println(b.update(sql,20,95002));
        System.out.println(select);
    }


    public int update(String sql,Object...args) {
        Connection conn = JdbcUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e1) {
            e1.printStackTrace();
        };

        int i = 1;
        int rows = 0;
        for(Object o : args) {
            try {
                ps.setObject(i, o);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            i++;
        }

        try {
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.closeConnection(rs, ps, conn);
        return rows;
    }

    public<T> ArrayList<T> select(String sql,Class<T> clz,Object...args){
        ArrayList<T> list = new ArrayList<>();
        Connection conn = JdbcUtil.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            int index = 1;
            for(Object o:args) {
                ps.setObject(index, o);
                index++;
            }
            ResultSet rs = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData md = rs.getMetaData();
            //获取结果集的列数
            int count = md.getColumnCount();
            System.out.println(count);
            while(rs.next()) {

                Constructor<T> constructor = null;
                T t = null;
                try {
                    //获取对象的构造器
                    constructor = clz.getConstructor();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
                try {
                    //根据构造器创建对象
                    t = constructor.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < count; i++) {
                    //获取结果的列名和每列的值
                    String columnName = md.getColumnName(i+1);
                    Object value = rs.getObject(columnName);
                    //根据列名给对象的属性赋值
                    Field f = null;
                    try {
                        f = clz.getDeclaredField(columnName);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                    f.setAccessible(true);
                    try {
                        f.set(t, value);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

                list.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}
