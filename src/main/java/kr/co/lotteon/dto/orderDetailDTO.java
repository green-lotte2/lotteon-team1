package kr.co.lotteon.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class orderDetailDTO {

    private int detailNo;
    private int orderNo;
    private int prodNo;
    private int optNo;
    private int count;
    private int detailPrice;
    private int detailPoint;
    private String detailStatus;

}
