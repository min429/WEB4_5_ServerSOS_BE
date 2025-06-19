package com.pickgo.global.email;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pickgo.domain.reservation.entity.Reservation;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    public void sendReservationEmail(Reservation reservation) {
        String email = reservation.getMember().getEmail();
        String subject = "[pickgo] 예매가 완료되었습니다";
        StringBuilder body = new StringBuilder();
        body.append("안녕하세요, ").append(reservation.getMember().getNickname()).append("님\n\n");
        body.append("예약이 성공적으로 완료되었습니다.\n\n");
        body.append("📅 공연명: ").append(reservation.getPerformanceSession().getPerformance().getName()).append("\n");

        LocalDateTime performanceTime = reservation.getPerformanceSession().getPerformanceTime();
        String formatted = performanceTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
        body.append("🗓️ 공연일시: ").append(formatted).append("\n");
        body.append("공연장명: ")
            .append(reservation.getPerformanceSession().getPerformance().getVenue().getName())
            .append("\n");
        body.append("공연장 주소: ")
            .append(reservation.getPerformanceSession().getPerformance().getVenue().getAddress())
            .append("\n");

        String seats = reservation.getReservedSeats().stream()
            .map(rs -> "%s %s %s%s".formatted(
                rs.getPerformanceArea().getName().getValue(),
                rs.getPerformanceArea().getGrade().getValue(),
                rs.getRow(),
                rs.getNumber()))
            .collect(Collectors.joining(", "));
        body.append("💺 좌석: ").append(seats).append("\n");
        body.append("💳 결제 금액: ").append(reservation.getTotalPrice()).append("원\n");
        body.append("감사합니다.");

        sendEmail(email, subject, body.toString());
    }
}
