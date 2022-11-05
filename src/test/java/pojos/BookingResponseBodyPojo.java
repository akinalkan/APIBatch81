package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
//Bu annotation aynı levelde bilinmeyen verileri  görmezden gelerek diğer verilerin bu class tipinde Pojo class'a çevrilmesine yarıyor.
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponseBodyPojo {

    private Integer bookingid;
    private BookingPojo bookingname;

    public BookingResponseBodyPojo(Integer bookingid, BookingPojo bookingname) {
        this.bookingid = bookingid;
        this.bookingname = bookingname;
    }

    public BookingResponseBodyPojo() {
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBookingname() {
        return bookingname;
    }

    public void setBookingname(BookingPojo bookingname) {
        this.bookingname = bookingname;
    }

    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingid=" + bookingid +
                ", bookingname=" + bookingname +
                '}';
    }
}
