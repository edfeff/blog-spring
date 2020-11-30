package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

/**
 * -- auto-generated definition
 * create table goadmin_menu
 * (
 * id         int unsigned auto_increment primary key,
 * parent_id  int(11) unsigned    default 0                 not null,
 * type       tinyint(4) unsigned default 0                 not null,
 * `order`    int(11) unsigned    default 0                 not null,
 * title      varchar(50)                                   not null,
 * icon       varchar(50)                                   not null,
 * uri        varchar(3000)       default ''                not null,
 * header     varchar(150)                                  null,
 * created_at timestamp           default CURRENT_TIMESTAMP null,
 * updated_at timestamp           default CURRENT_TIMESTAMP null
 * )
 * collate = utf8mb4_unicode_ci;
 */
public class PrepareStatementSample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/godmin", "admin", "admin");

        PreparedStatement statement = connection.prepareStatement("select * from goadmin_menu where id = ?");

        statement.setInt(1, 1);

        ResultSet resultSet = statement.executeQuery();

        Menu menu = new Menu();

        while (resultSet.next()) {
            menu.setId(resultSet.getInt("id"));
            menu.setParent_id(resultSet.getInt("parent_id"));
            menu.setType(resultSet.getInt("type"));
            menu.setOrder(resultSet.getInt("order"));
            menu.setTitle(resultSet.getString("title"));
            menu.setUri(resultSet.getString("uri"));
            menu.setHeader(resultSet.getString("header"));
            menu.setIcon(resultSet.getString("icon"));
            menu.setCreated_at(resultSet.getDate("created_at"));
            menu.setUpdated_at(resultSet.getDate("updated_at"));
        }

        System.out.println(menu);

        resultSet.close();
        statement.close();
        connection.close();

    }

    static class Menu {
        private Integer id;//int unsigned auto_increment primary key,
        private Integer parent_id;//int(11) unsigned    default 0                 not null,
        private Integer type;//tinyint(4) unsigned default 0                 not null,
        private Integer order;
        private String title;//varchar(50)                                   not null,
        private String icon;//varchar(50)                                   not null,
        private String uri;//varchar(3000)       default ''                not null,
        private String header;//varchar(150)                                  null,
        private Date created_at;//timestamp           default CURRENT_TIMESTAMP null,
        private Date updated_at;//timestamp           default CURRENT_TIMESTAMP null

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getParent_id() {
            return parent_id;
        }

        public void setParent_id(Integer parent_id) {
            this.parent_id = parent_id;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public Date getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Date created_at) {
            this.created_at = created_at;
        }

        public Date getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(Date updated_at) {
            this.updated_at = updated_at;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "id=" + id +
                    ", parent_id=" + parent_id +
                    ", type=" + type +
                    ", order=" + order +
                    ", title='" + title + '\'' +
                    ", icon='" + icon + '\'' +
                    ", uri='" + uri + '\'' +
                    ", header='" + header + '\'' +
                    ", created_at=" + created_at +
                    ", updated_at=" + updated_at +
                    '}';
        }
    }
}
