package store.model;

import java.util.HashMap;

public class StoreDB {
    public HashMap<String, Store> setStoreInformation(){
        HashMap<String, Store> savedStores = new HashMap<>();

        Store store = new Store("조조칼국수", "한식", "칼국수","전라도");
        Menu storeMenu = store.getMenu();
        storeMenu.addDish(1,"동죽칼국수", 9000, "살아있는 동죽과 신선한 야채");
        storeMenu.addDish(2,"낙지해물파전", 13000, "낙지,오징어,새우가 듬뿍");
        storeMenu.addDish(3,"물총조개탕", 12000, "살아있는 동죽이 가득");
        storeMenu.addDish(4,"막걸리", 5000, "");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("팔각도", "한식", "닭갈비","서울");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"숯불 닭갈비", 12900, "전국 팔도를 돌아다니며 새롭게 정립한 닭갈비");
        storeMenu.addDish(2,"닭 오돌오돌 만두", 13000, "매콤하고 독특한 식감의 닭 무릎 연골");
        storeMenu.addDish(3,"비빔 칼국수", 7000, "탱글탱글 면발과 직접 만든 특별소스의 조화");
        storeMenu.addDish(4,"짬뽕 칼국수", 8000, "각종 해산물이 들어가 깊은 맛이 나는 짬뽕");
        storeMenu.addDish(5,"통다리 닭곰탕", 9900, "큼지막한 닭다리를 통째로 고아 만든 닭곰탕");
        storeMenu.addDish(6,"통다리 닭개장", 10900, "큼지막한 닭다리와 얼큰한 닭개장 국물");
        storeMenu.addDish(7,"파인애플 샤베트", 7000, "싱싱한 생 열대과일로 만든 샤베트");
        storeMenu.addDish(8,"하이볼", 7900, "");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("담미온", "한식", "국밥", "경기도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"수육국밥", 10000, "");
        storeMenu.addDish(2,"순대국밥", 10000, "");
        storeMenu.addDish(3,"얼큰국밥", 10000, "");
        storeMenu.addDish(4,"수육곰탕", 10000, "");
        storeMenu.addDish(5,"수육정식", 16000, "");
        storeMenu.addDish(6,"보쌈정식", 12000, "2인 이상만 주문 가능");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("보끔당", "한식", "닭볶음탕","경기도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"닭볶음당세트", 37000, "보끔당 닭볶음탕+새우파튀 (2~3인분)");
        storeMenu.addDish(2,"보끔당 닭볶음탕", 27000, "(2~3인분)");
        storeMenu.addDish(3,"뚝배기닭볶음탕", 12000,"BEST 보끔당 점심 1인 인기메뉴 (국내산 순살)");
        storeMenu.addDish(4,"간장찜닭(2~3인분)", 28000, "(2~3인분)");
        storeMenu.addDish(5,"묵은지뚝배기닭볶음탕", 15000, "보끔당의 히든카드 묵은지 닭볶음탕 1인 메뉴");
        storeMenu.addDish(6,"무뼈닭발튀김", 14000, "");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("멘야마쯔리", "일식", "라멘","서울");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"멘야마제소바", 10500, "신개념 비벼먹는 라멘");
        storeMenu.addDish(2,"하카타 돈코츠라멘", 9000, "현지의 맛 그대로");
        storeMenu.addDish(3,"카라구찌라멘", 9000, "매운맛 마니아들을 위한 라멘");
        storeMenu.addDish(4,"멘야미소라멘", 9000, "깊고 진한 돈코츠 베이스");
        storeMenu.addDish(5,"츠케멘", 12000, "통 밀 후토멘을 소바처럼 찍어먹는 라멘");
        storeMenu.addDish(6,"화산라멘", 12000, "돌솥 5단계의 불타는 매운맛");
        storeMenu.addDish(7,"교자", 5000, "");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("탐광", "일식", "가츠동", "충청도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"에비가츠동", 14000, "일본식 새우튀김 덮밥");
        storeMenu.addDish(2,"대창소고기카레누들", 15000, "대창이 올라간 카레 누들");
        storeMenu.addDish(3,"치즈에비가츠동", 16000, "치즈가 올라간 에비가츠동");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("호랑이 초밥", "일식", "초밥", "경상도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"호랑이모듬", 12000, "광어/연어/참치/황새치/초새우/초문어/조합치/황새치테이크초밥/계란/유부");
        storeMenu.addDish(2,"호랑이특모듬", 16000, "광어2p/활어/연어2p/참치/황새치/초새우/간장새우/황새치스테이크/소고기/관자구이");
        storeMenu.addDish(3,"사시미2인", 20000, "");
        storeMenu.addDish(4,"사시미3~4인", 38000, "");
        storeMenu.addDish(5,"도로초밥", 20000, "");
        storeMenu.addDish(6,"올리브연어아보카드", 18000, "");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("미도인", "양식", "덮밥","경상도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"미도인 스테이크 덮밥", 10500, "부채살 스테이크를 올린 덮밥");
        storeMenu.addDish(2,"미도인 9첩반상", 14800, "스테이크 덮밥+소바+왕새우 튀김");
        storeMenu.addDish(3,"미도인 등심 스테이크", 16800, "숙성 스테이크+단호박 스프+아지다마고의 한상차림");
        storeMenu.addDish(4,"미도인 등심 스테이크 덮밥 한상", 15800, "");
        storeMenu.addDish(5,"곱창 대창 덮밥", 13900, "");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("나이스두잉", "양식", "버거","서울");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"와사비쉬림프", 10000, "대표 버거");
        storeMenu.addDish(2,"플레인치즈", 6500, "");
        storeMenu.addDish(3,"클래식치즈", 7500, "");
        storeMenu.addDish(4,"베이컨치즈", 8800, "");
        storeMenu.addDish(5,"하와이안베이컨", 9800, "");
        storeMenu.addDish(6,"나이스두잉", 9800, "대표 버거");
        storeMenu.addDish(7,"비프앤쉬림프", 14000, "");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("더플해피니스", "중식", "마라샹궈", "전라도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"스페어 립 마라샹궈", 37000, "스페어 립 BBQ가 올라간 매콤한 마라샹궈");
        storeMenu.addDish(2,"마라샹궈 한 접시", 28000, "매콤 짜릿한 마라샹궈");
        storeMenu.addDish(3,"라후후 바지락볶음", 20000,"강한불에 볶아 얼큰하게 끓인 국물의 바지락 술찜");
        storeMenu.addDish(4,"청홍 유린기", 17000,"청홍고추폭탄 유린기");
        storeMenu.addDish(5,"쓰촨식 라즈지", 23000,"닭튀김과 고추가 어우러진 사천식 라즈지");
        storeMenu.addDish(6,"사천식 마파두부", 22000,"마파두부요리 한 접시");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("착한짜장", "중식", "짜장면", "강원도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"착한짜장면", 7000, "");
        storeMenu.addDish(2,"해물쟁반짜장", 9000, "해물이 들어간 쟁반짜장");
        storeMenu.addDish(4,"새우볶음밥", 10000,"");
        storeMenu.addDish(5,"탕수육(소)", 18000,"1인");
        storeMenu.addDish(6,"탕수육(중)", 23000,"2~3인");
        storeMenu.addDish(7,"탕수육(대)", 28000,"4인");
        storeMenu.addDish(8,"양장피(소)", 28000,"1인");
        storeMenu.addDish(9,"양장피(중)", 33000,"2~3인");
        storeMenu.addDish(10,"양장피(대)", 38000,"4인");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("37.5 시그니처 성수", "기타", "파스타", "서울");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"정통 미국식 브런치", 18900, "프렌치토스트와 부드러운 팬케익,각종 사이드디쉬,샐러드");
        storeMenu.addDish(2,"몬테크리스토 샌드위치", 18900, "각종 치즈와 수제 콤포트, 짜쪼롬한 하몽");
        storeMenu.addDish(3,"몽블랑 트러플 파스타", 22900,"트러플의 깊은 풍미를 더한 크림 파스타를 바삭하고 쫀득한 몽블랑 데니쉬");
        storeMenu.addDish(4,"시그니처 명란 오일 파스타", 19900, "각종 해산물과 마늘, 신선한 명란");
        storeMenu.addDish(5,"리코타 샐러드 피자", 19900,"수제 리코타 치즈를 토핑");
        storeMenu.addDish(6,"소다에이드", 6500,"");
        storeMenu.addDish(7,"자두에이드", 6000,"");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        store = new Store("호랑이분식", "기타", "떡볶이","충청도");
        storeMenu = store.getMenu();
        storeMenu.addDish(1,"호랑이떡볶이", 6500, "대표 떡볶이");
        storeMenu.addDish(2,"짜장떡볶이", 6500,"");
        storeMenu.addDish(3,"호랑이돈가스", 12500,"대표 돈가슨");
        storeMenu.addDish(4,"어묵우동", 8500,"");
        storeMenu.addDish(5,"에그마요김밥", 5000,"에그마요 토핑이 잔뜩 올라간 김밥");
        storeMenu.addDish(6,"불고기김밥", 6500,"불고기 토핑이 잔뜩 올라간 김밥");
        storeMenu.addDish(7,"모듬튀김", 4500,"야채튀김+김말이+계란튀김");
        savedStores.put(store.getStoreName(), store);
        store.setAveragePrice();

        return savedStores;
    }
}
