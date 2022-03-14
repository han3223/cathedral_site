FROM amazoncorretto
ENV HOST="0.0.0.0"
ENV PORT=8080
EXPOSE 8080:8080
RUN mkdir /app
COPY ./build/install/testDocker/ /app/
WORKDIR /app/bin
CMD ["./testDocker"]

