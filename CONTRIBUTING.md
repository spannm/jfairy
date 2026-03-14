# Contributing to jFairy

We welcome contributions! Here's how to get started.

## Getting Started

1. Fork the repository
2. Clone your fork: `git clone https://github.com/YOUR_USERNAME/jfairy.git`
3. Create a branch: `git checkout -b feat/your-feature`
4. Make your changes
5. Run tests: `./mvnw test`
6. Push and open a Pull Request

## Requirements

- Java 17+
- Maven 4 (included via `./mvnw` wrapper)

## Adding a New Locale

1. Create `src/main/resources/jfairy_XX.yml` with names, cities, streets, etc.
2. Add provider classes in `src/main/java/.../producer/person/locale/xx/`
   - `XxAddress` + `XxAddressProvider`
   - `XxNationalIdentityCardNumberProvider`
   - `XxPassportNumberProvider`
3. Add VAT provider in `src/main/java/.../producer/company/locale/xx/`
4. Add `XX` to `LanguageCode` enum and `Country` enum
5. Wire in `LocaleSpecificProvidersFactory` (add case + factory method)
6. Add tests

See existing locales (e.g., `br`, `sk`) for reference.

## Guidelines

- Follow existing code style
- Write tests for new functionality
- Use `baseProducer` for random values (not `Math.random()` or `RandomStringUtils`) to keep seed determinism
- Keep commits focused — one logical change per commit
- Use [Conventional Commits](https://www.conventionalcommits.org/) format

## Running Tests

```bash
./mvnw test
```
