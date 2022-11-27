interface Message {
    void show(double money);
}
enum Pay implements Message {
    Cash() {
        @Override
        public void show(double money) {
            System.out.println("现金支付" + money);
        }
    },
    WeChatPay {
        @Override
        public void show(double money) {
            System.out.println("微信支付" + money);
        }
    },
    Alipay {
        @Override
        public void show(double money) {
            System.out.println("支付宝支付" + money);
        }
    },
    BankCard {
        @Override
        public void show(double money) {
            System.out.println("银行卡支付" + money);
        }
    },
    CreditCard {
        @Override
        public void show(double money) {
            System.out.println("信用卡支付" + money);
        }
    };
}
class PayEnum {
    double money;
    Pay p;
    PayEnum(Pay type, double m) {
        p = type;
        money = m;
    }
    void show () {
        p.show(money);
    }
}
public class test1 {
    public static void main(String[] args) {
        PayEnum p1 = new PayEnum(Pay.Cash, 10000);
        PayEnum p2 = new PayEnum(Pay.WeChatPay, 10130.3);
        PayEnum p3 = new PayEnum(Pay.Alipay, 1099.1);
        PayEnum p4 = new PayEnum(Pay.BankCard, 10.12);
        PayEnum p5 = new PayEnum(Pay.CreditCard, 19900);
        p1.show();
        p2.show();
        p3.show();
        p4.show();
        p5.show();
    }
}
