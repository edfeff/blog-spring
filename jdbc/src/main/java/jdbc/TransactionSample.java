package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


public class TransactionSample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/godmin", "admin", "admin");

        connection.setAutoCommit(false);

        String sql = "INSERT INTO godmin.goadmin_menu " +
                "(parent_id, type, `order`, title, icon, uri, header, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        Menu menu = new Menu(1, 1, 1, "dmeo", "dmeo", "demo:uri", "header:demo", new Date(), new Date());

        statement.setInt(1, menu.getParent_id());
        statement.setInt(2, menu.getType());
        statement.setInt(3, menu.getOrder());
        statement.setString(4, menu.getTitle());
        statement.setString(5, menu.getIcon());
        statement.setString(6, menu.getUri());
        statement.setString(7, menu.getHeader());
        statement.setDate(8, new java.sql.Date(menu.getCreated_at().getTime()));
        statement.setDate(9, new java.sql.Date(menu.getUpdated_at().getTime()));

        int i = statement.executeUpdate();

        System.out.println(i);

        connection.commit();
        statement.close();
        connection.close();

    }

    static class Menu {
        public Menu(Integer parent_id, Integer type, Integer order, String title, String icon, String uri, String header, Date created_at, Date updated_at) {
            this.parent_id = parent_id;
            this.type = type;
            this.order = order;
            this.title = title;
            this.icon = icon;
            this.uri = uri;
            this.header = header;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }

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
