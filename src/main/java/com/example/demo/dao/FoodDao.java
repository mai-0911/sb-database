package com.example.demo.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FoodDao {
	//「interface」クラスと似たもの(特徴：処理内容を持たないメソッドだけを記述)

	// foodテーブルから、カテゴリ名(category_name) を条件に、該当する全ての食品名(food_name) を取得する
	//「”””(3連ダブルクォーテーション)」で囲うとその中で自由に改行可能
	@Select(""" 
			SELECT
			  food_name
			FROM
			  food
			WHERE
			  category_name = #{searchWord};
			""")
	//｛処理内容｝の部分がない特殊なメソッドとして定義
	//処理内容の部分はSpringBootが自動的に作成してくれる
	//メソッド定義部分↓
	public ArrayList<String> selectFoodName(String searchWord);

}
