# Dangdang
애견 쇼핑몰 모음 앱

## 기능
_**Menu**_
  1. **카테고리**  
    * 의류, 음식, 집, 장난감별로 여러 쇼핑몰의 물품을 한 눈에 볼 수 있다.   
    * 물품을 클릭하면 쇼핑몰로 이동하여 직접 구매가 가능하다.  
    
  2. **쇼핑몰 이동**  
    * 쇼핑몰들을 리스트 형태로 볼 수 있다.
    * 즐겨찾기 추가&삭제 가능
    * 쇼핑몰 검색 가능
    
  3. **즐겨찾기**  
    * 등록한 쇼핑몰로 이동 가능
    
_**Implementation**_
* Jsoup을 이용해 Web source 파싱
* 로딩 중 ( ProgressDialog로 구현 )
* Custom ListAdapter로 물품들 나열 
  + ViewHolder, CardView 
  + image load with Glide
* etc..
