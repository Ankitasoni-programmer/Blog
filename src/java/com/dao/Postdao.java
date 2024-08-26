/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;
import com.entities.Category;
import com.entities.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Postdao {
    Connection con;

    public Postdao(Connection con) {
        this.con = con;
    }
    
    
    
    public ArrayList<Category>getAllCategories()
    {
        ArrayList<Category>list=new ArrayList<>();
        try{
            String q="select * from categories";
            Statement st=con.createStatement();
            ResultSet set=st.executeQuery(q);
            while(set.next())
            {
                int cid=set.getInt("cid");
                String name=set.getString("name");
                String description=set.getString("description");
                Category c= new Category(cid,name,description);
                list.add(c);
                
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        return list;
    }
    public boolean savepost(Post p)
    {
        boolean f=false;
        try{
            String q="insert into post(ptitle,pcontent,pcode,ppic,catid,userid)values(?,?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(q);
            pstmt.setString(1, p.getPtitle());
            pstmt.setString(2, p.getPcontent());
            pstmt.setString(3, p.getPcode());
            pstmt.setString(4,p.getPpic());
            pstmt.setInt(5,p.getCatid());
            pstmt.setInt(6, p.getUserid());
            pstmt.executeUpdate();
            f=true;
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return f;
    }
    
    //    get all the posts
    public List<Post> getAllPosts() {

        List<Post> list = new ArrayList<>();
        //fetch all the post
        try {

            PreparedStatement p = con.prepareStatement("select * from post  order by idpost desc");

            ResultSet set = p.executeQuery();

            while (set.next()) {

                int pid = set.getInt("idpost");
                String pTitle = set.getString("ptitle");
                String pContent = set.getString("pcontent");
                String pCode = set.getString("pcode");
                String pPic = set.getString("ppic");
                Timestamp date = set.getTimestamp("pdate");
                int catId = set.getInt("catid");
                int userId = set.getInt("userid");
                Post post = new Post(pid, pTitle, pContent, pCode, pPic, date, catId, userId);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
     public List<Post> getPostByCatId(int catid) {
        List<Post> list = new ArrayList<>();
        //fetch all post by id
        //fetch all the post
        try {

            PreparedStatement p = con.prepareStatement("select * from post where catid=?");
            p.setInt(1, catid);
            ResultSet set = p.executeQuery();

            while (set.next()) {

                int pid = set.getInt("idpost");
                String pTitle = set.getString("ptitle");
                String pContent = set.getString("pcontent");
                String pCode = set.getString("pcode");
                String pPic = set.getString("ppic");
                Timestamp date = set.getTimestamp("pdate");

                int userId = set.getInt("userId");
                Post post = new Post(pid, pTitle, pContent, pCode, pPic, date, catid, userId);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
